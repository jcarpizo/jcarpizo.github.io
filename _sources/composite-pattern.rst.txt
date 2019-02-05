Composite Pattern in PHP
========================

In the Composite pattern an individual object or a group of that object will have similar behaviors.

In this example, the ``OneBook`` class is the individual object. The ``SeveralBooks`` class is a group of zero or more ``OneBook`` objects.

Both the ``OneBook`` and ``SeveralBooks`` can return information about the books title and author. OneBook can only return this information about one single book, while ``SeveralBooks`` will return this information one at a time about as many ``OneBooks`` as it holds.

While both classes have ``addBook`` and ``removeBook`` functions, they are only functional on  ``SeveralBooks``. ``OneBook`` will merely return FALSE when these functions are called.


.. code-block:: php
   :linenos:

    abstract class OnTheBookShelf
    {
        abstract function getBookInfo($previousBook);
        abstract function getBookCount();
        abstract function setBookCount($new_count);
        abstract function addBook($oneBook);
        abstract function removeBook($oneBook);
    }

    class OneBook extends OnTheBookShelf
    {
        private $title;
        private $author;

        public function __construct($title, $author)
        {
            $this->title = $title;
            $this->author = $author;
        }

        public function getBookInfo($bookToGet)
        {
            if (1 == $bookToGet) {
                return $this->title." by ".$this->author;
            } else {
                return false;
            }
        }

        public function getBookCount()
        {
            return 1;
        }

        public function setBookCount($newCount)
        {
            return false;
        }

        public function addBook($oneBook)
        {
            return false;
        }

        public function removeBook($oneBook)
        {
            return false;
        }
    }

    class SeveralBooks extends OnTheBookShelf
    {
        private $oneBooks = array();
        private $bookCount;

        public function __construct()
        {
            $this->setBookCount(0);
        }

        public function getBookCount()
        {
            return $this->bookCount;
        }

        public function setBookCount($newCount)
        {
            $this->bookCount = $newCount;
        }

        public function getBookInfo($bookToGet)
        {
            if ($bookToGet <= $this->bookCount) {
                return $this->oneBooks[$bookToGet]->getBookInfo(1);
            } else {
                return false;
            }
        }

        public function addBook($oneBook)
        {
            $this->setBookCount($this->getBookCount() + 1);
            $this->oneBooks[$this->getBookCount()] = $oneBook;
            return $this->getBookCount();
        }

        public function removeBook($oneBook)
        {
            $counter = 0;
            while (++$counter <= $this->getBookCount()) {
                if ($oneBook->getBookInfo(1) ==
                    $this->oneBooks[$counter]->getBookInfo(1)) {
                    for ($x = $counter; $x < $this->getBookCount(); $x++) {
                        $this->oneBooks[$x] = $this->oneBooks[$x + 1];
                    }
                    $this->setBookCount($this->getBookCount() - 1);
                }
            }
            return $this->getBookCount();
        }
    }

    writeln("BEGIN TESTING COMPOSITE PATTERN");
    writeln('');

    $firstBook = new OneBook('Core PHP Programming, Third Edition', 'Atkinson and Suraski');
    writeln('(after creating first book) oneBook info: ');
    writeln($firstBook->getBookInfo(1));
    writeln('');

    $secondBook = new OneBook('PHP Bible', 'Converse and Park');
    writeln('(after creating second book) oneBook info: ');
    writeln($secondBook->getBookInfo(1));
    writeln('');

    $thirdBook = new OneBook('Design Patterns', 'Gamma, Helm, Johnson, and Vlissides');
    writeln('(after creating third book) oneBook info: ');
    writeln($thirdBook->getBookInfo(1));
    writeln('');

    $books = new SeveralBooks();

    $booksCount = $books->addBook($firstBook);
    writeln('(after adding firstBook to books) SeveralBooks info : ');
    writeln($books->getBookInfo($booksCount));
    writeln('');

    $booksCount = $books->addBook($secondBook);
    writeln('(after adding secondBook to books) SeveralBooks info : ');
    writeln($books->getBookInfo($booksCount));
    writeln('');

    $booksCount = $books->addBook($thirdBook);
    writeln('(after adding thirdBook to books) SeveralBooks info : ');
    writeln($books->getBookInfo($booksCount));
    writeln('');

    $booksCount = $books->removeBook($firstBook);
    writeln('(after removing firstBook from books) SeveralBooks count : ');
    writeln($books->getBookCount());
    writeln('');

    writeln('(after removing firstBook from books) SeveralBooks info 1 : ');
    writeln($books->getBookInfo(1));
    writeln('');

    writeln('(after removing firstBook from books) SeveralBooks info 2 : ');
    writeln($books->getBookInfo(2));
    writeln('');

    writeln('END TESTING COMPOSITE PATTERN');

    function writeln($line_in)
    {
        echo $line_in."<br/>";
    }


::

    BEGIN TESTING COMPOSITE PATTERN

    (after creating first book) oneBook info:
    Core PHP Programming, Third Edition by Atkinson and Suraski

    (after creating second book) oneBook info:
    PHP Bible by Converse and Park

    (after creating third book) oneBook info:
    Design Patterns by Gamma, Helm, Johnson, and Vlissides

    (after adding firstBook to books) SeveralBooks info :
    Core PHP Programming, Third Edition by Atkinson and Suraski

    (after adding secondBook to books) SeveralBooks info :
    PHP Bible by Converse and Park

    (after adding thirdBook to books) SeveralBooks info :
    Design Patterns by Gamma, Helm, Johnson, and Vlissides

    (after removing firstBook from books) SeveralBooks count : 2

    (after removing firstBook from books) SeveralBooks info 1 :
    PHP Bible by Converse and Park

    (after removing firstBook from books) SeveralBooks info 2 :
    Design Patterns by Gamma, Helm, Johnson, and Vlissides

    END TESTING COMPOSITE PATTERN

.. meta::
    :description: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :keywords: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :author: Jasper Carpizo