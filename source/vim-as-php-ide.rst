Vi / Vim Editor as PHP IDE
==========================

Create ~/.vimrc and add the following lines
-------------------------------------------

.. code-block:: console

        " Specify a directory for plugins
        " - For Neovim: ~/.local/share/nvim/plugged
        " - Avoid using standard Vim directory names like 'plugin'
        call plug#begin('~/.vim/plugged')

        " Make sure you use single quotes

        " Shorthand notation; fetches https://github.com/junegunn/vim-easy-align
        Plug 'junegunn/vim-easy-align'

        " Any valid git URL is allowed
        Plug 'https://github.com/junegunn/vim-github-dashboard.git'

        " Multiple Plug commands can be written in a single line using | separators
        Plug 'SirVer/ultisnips' | Plug 'honza/vim-snippets'

        " On-demand loading
        Plug 'scrooloose/nerdtree', { 'on':  'NERDTreeToggle' }
        Plug 'tpope/vim-fireplace', { 'for': 'clojure' }

        " Using a non-master branch
        Plug 'rdnetto/YCM-Generator', { 'branch': 'stable' }

        " Using a tagged release; wildcard allowed (requires git 1.9.2 or above)
        Plug 'fatih/vim-go', { 'tag': '*' }

        " Plugin options
        Plug 'nsf/gocode', { 'tag': 'v.20150303', 'rtp': 'vim' }

        " Plugin outside ~/.vim/plugged with post-update hook
        Plug 'junegunn/fzf', { 'dir': '~/.fzf', 'do': './install --all' }

        " Unmanaged plugin (manually installed and updated)
        Plug '~/my-prototype-plugin'

        " Initialize plugin system

        Plug 'vim-scripts/taglist.vim'
        Plug 'StanAngeloff/php.vim'
        Plug 'lvht/phpcd.vim', { 'for': 'php', 'do': 'composer install' }
        Plug 'ervandew/supertab'
        Plug 'nlknguyen/papercolor-theme'
        Plug 'vim-airline/vim-airline'
        Plug 'borissov/vim-mysql-suggestions'
        Plug 'jparise/vim-graphql'
        Plug 'scrooloose/syntastic'
        Plug 'yggdroot/indentline'
        Plug 'symfony/symfony'
        Plug 'blueshirts/darcula'

        if has('nvim')
          Plug 'Shougo/deoplete.nvim', { 'do': ':UpdateRemotePlugins' }
        else
          Plug 'Shougo/deoplete.nvim'
          Plug 'roxma/nvim-yarp'
          Plug 'roxma/vim-hug-neovim-rpc'
        endif
        let g:deoplete#enable_at_startup = 1

        call plug#end()

        set number
        syntax enable
        set background=dark
        colorscheme darcula
        set laststatus=2
        set tabstop=4
        set softtabstop=0 noexpandtab
        set shiftwidth=4
        set tabstop=8 softtabstop=0 expandtab shiftwidth=4 smarttab
        set autoindent
        inoremap " ""<left>
        inoremap ' ''<left>
        inoremap ( ()<left>
        inoremap [ []<left>
        inoremap { {}<left>
        inoremap {<CR> {<CR>}<ESC>O
        inoremap {;<CR> {<CR>};<ESC>O

        autocmd vimenter * NERDTree
        autocmd StdinReadPre * let s:std_in=1
        autocmd VimEnter * if argc() == 0 && !exists("s:std_in") | NERDTree | endif
        autocmd StdinReadPre * let s:std_in=1
        autocmd VimEnter * if argc() == 1 && isdirectory(argv()[0]) && !exists("s:std_in") | exe 'NERDTree' argv()[0] | wincmd p | ene | exe 'cd '.argv()[0] | endif
        map <C-n> :NERDTreeToggle<CR>
        autocmd bufenter * if (winnr("$") == 1 && exists("b:NERDTree") && b:NERDTree.isTabTree()) | q | endif


        function! PhpSyntaxOverride()
          " Put snippet overrides in this function.
          hi! link phpDocTags phpDefine
          hi! link phpDocParam phpType
        endfunction
        augroup phpSyntaxOverride
          autocmd!
          autocmd FileType php call PhpSyntaxOverride()
        augroup END
        hi phpUseNamespaceSeparator guifg=#808080 guibg=NONE gui=NONE
        hi phpClassNamespaceSeparator guifg=#808080 guibg=NONE gui=NONE
        syn match phpParentOnly "[()]" contained containedin=phpParent
        hi phpParentOnly guifg=#f08080 guibg=NONE gui=NONE

        let g:deoplete#ignore_sources = get(g:, 'deoplete#ignore_sources', {})
        let g:deoplete#ignore_sources.php = ['omni']
        let g:phpcd_php_cli_executable = 'php7.3'

        let g:indentLine_setColors = 0


VimPlug
-------

then run the following in Vim

.. code-block:: console

    :source %
    :PlugInstall


Screenshot
----------

.. raw:: html

    <img src="image/editor1.png" />

     <img src="image/editor2.png" />
