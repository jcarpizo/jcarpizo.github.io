import sys, os, guzzle_sphinx_theme
from sphinx.highlighting import lexers
from pygments.lexers.web import PhpLexer

pygments_style = 'native'
#import sphinx_ustack_theme

extensions = [
    'sphinxcontrib.phpdomain'
]

lexers['php'] = PhpLexer(startinline=True, linenos=1)
lexers['php-annotations'] = PhpLexer(startinline=True, linenos=1)
primary_domain = 'php'
templates_path = ['_templates']
source_suffix = '.rst'
master_doc = 'index'
project = u'jcarpizo.github.io'
copyright = u'2004-2017 Jasper Carpizo'
version = 'new \DateTimeImmutable()'
html_title = "Jasper Carpizo"
html_short_title = "Reference Documentation"

exclude_patterns = ['_build']
html_static_path = ['_static']

#html_theme_path = guzzle_sphinx_theme.html_theme_path()
html_theme = "sphinx_rtd_theme"

html_show_sourcelink = False
html_show_sphinx = False
html_experimental_html5_writer = True
html_show_copyright = True

html_sidebars = {
    '**': ['logo-text.html', 'searchbox.html', 'globaltoc.html' ]
}
html_file_suffix = '.html'
html_favicon="../_static/jenkins.ico"

html_theme_options = {

    # Set the path to a special layout to include for the homepage
    #"index_template": "special_index.html",

    # Set the name of the project to appear in the left sidebar.
    #"project_nav_name": "Jasper Carpizo",

    # Set your Disqus short name to enable comments
    #"disqus_comments_shortname": "https-jcarpizo-github-io",

    # Set you GA account ID to enable tracking
    #"google_analytics_account": "UA-133821205-1",
    "analytics_id": "UA-133821205-1",

    # Path to a touch icon
    #"touch_icon": "",

    # Specify a base_url used to generate sitemap.xml links. If not
    # specified, then no sitemap will be built.
    #"base_url": ""

    # Allow a separate homepage from the master_doc
    #"homepage": "index",

    # Allow the project link to be overriden to a custom URL.
    #"projectlink": "http://myproject.url",
}

html_context = {
  'display_github': False,
  'github_user': 'jcarpizo',
  'github_repo': 'jcarpizo.github.io',
  'github_version': 'master',
  'conf_py_path': '/source/'
}
