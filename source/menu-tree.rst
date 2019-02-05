Build a Menu with Recursive Functions
=====================================

MenuController.php
------------------

.. code-block:: php
    :linenos:

    <?php

    namespace HighStatus\Http\Controllers\Admin;

    use HighStatus\Services\MenuServiceInterface;
    use Illuminate\Support\Facades\Route;

    class MenuController extends Controller
    {
        private $menuService;

        public function __construct(MenuServiceInterface $menuService)
        {
            $this->menuService = $menuService;
        }

        public function getMenus(string $className = null)
        {
            return $this->renderMenu($this->childrenParsing(), $className);
        }

        private function renderMenu(array $menus, string $className = null, int $int = 0)
        {
            $htmlView = null;
            foreach ($menus as $key => $menu) {
                $childCount = count($menu['children']);
                $dropDownIcon = ($childCount > 0 ? '<span class="fa arrow"></span>' : '');
                $htmlView .= '<li class="' . (Route::getFacadeRoot()->current()->uri() === $menu['route'] ? 'active' : '') .
                    '" ><a href="' . url($menu['route']) . '"><i class="' . $menu['class_icon'] . '"></i>
                    <span class="nav-label">' . $menu['name'] . '</span>' . $dropDownIcon . '</a>';
                if ($childCount > 0 && is_array($menu['children'])) {
                    $htmlView .= '<ul class="' . $className . '">';
                    $htmlView .= $this->renderMenu($menu['children'], $className, --$int + 1);
                    $htmlView .= '</ul>';
                }
                $htmlView .= '</li>';
            }
            return $htmlView;
        }

        private function childrenParsing(int $compositeId = 0)
        {
            $treeMenu = [];
            $menus = $this->menuService->getChild($compositeId);
            foreach ($menus as $key => $menu) {
                if (!empty($menu->id)) {
                    $treeMenu[] = [
                        'id' => $menu->id,
                        'composite_id' => $menu->id,
                        'name' => $menu->name,
                        'route' => $menu->route,
                        'class_icon' => $menu->class_icon,
                        'children' => $this->childrenParsing($menu->id),
                    ];
                }
            }
            return $treeMenu;
        }
    }


MenuServiceInterface.php
------------------------

..  code-block:: php
    :linenos:

    <?php

    namespace HighStatus\Services;

    interface MenuServiceInterface
    {
        public function add(array $data);

        public function remove();

        public function getChild(int $id);
    }


MenuService.php
---------------

.. code-block:: php
    :linenos:

    <?php

    namespace HighStatus\Services;

    use HighStatus\Models\Menu\Menu;
    use Illuminate\Support\Facades\DB;

    class MenuService implements MenuServiceInterface
    {
        public function add(array $data)
        {
            return Menu::create($data);
        }

        public function remove()
        {
        }

        public function getChild(int $id)
        {
            return DB::select('SELECT * FROM menu
                    WHERE composite_id = ?
                    ORDER BY CASE
                    WHEN name = "Dashboard" THEN 0 ELSE 1 END, name', [$id]);
        }
    }



MenuTrait.php
-------------

.. code-block:: php
    :linenos:

    <?php

    namespace HighStatus\Traits;

    use HighStatus\Http\Controllers\Admin\MenuController;
    use HighStatus\Services\MenuService;

    trait Menu
    {
        public static function displayMenu(string $navClassName = null)
        {
            $menu = new MenuController(new MenuService());
            echo $menu->getMenus($navClassName);
        }
    }


View [layout.blade.php]
-----------------------

.. code-block:: php
    :linenos:

    <?php

    HomeController::displayMenu('nav nav-second-level collapse');