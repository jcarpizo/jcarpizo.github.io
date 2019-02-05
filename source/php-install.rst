Install PHP 5.6 or PHP 7.1 on Ubuntu 16.04, 14.04 using PPA
===========================================================

Installing PHP 5.6 or PHP 7.1 using PPA on Ubuntu 16.10, 16.04 LTS, 14.04 LTS or 12.04 LTS systems. If you have already have higher version installed on your system and you need to install lower version, then you have to remove higher version first and remove apt repository from system.

=========================
Install PHP 5.6 on Ubuntu
=========================

Use the following set of command to add PPA for PHP 5.6 in your Ubuntu system and install PHP 5.6.

.. code-block:: console

    sudo apt-get install python-software-properties

    sudo add-apt-repository ppa:ondrej/php

    sudo apt-get update

    sudo apt-get install -y php5.6


Check Installed PHP Version:
----------------------------

.. code-block:: console


    $ php -v

    PHP 5.6.29-1+deb.sury.org~xenial+1 (cli)
    Copyright (c) 1997-2016 The PHP Group
    Zend Engine v2.6.0, Copyright (c) 1998-2016 Zend Technologies
    with Zend OPcache v7.0.6-dev, Copyright (c) 1999-2016, by Zend Technologies


=========================
Install PHP 7.1 on Ubuntu
=========================

Use the following set of command to add PPA for PHP 7.1 in your Ubuntu system and install PHP 7.1.

.. code-block:: console

    sudo apt-get install python-software-properties

    sudo add-apt-repository ppa:ondrej/php

    sudo apt-get update

    sudo apt-get install -y php7.1


Check Installed PHP Version:
----------------------------


.. code-block:: console

    $ php -v

    PHP 7.1.0-5+deb.sury.org~xenial+1 (cli) ( NTS )
    Copyright (c) 1997-2016 The PHP Group
    Zend Engine v3.1.0-dev, Copyright (c) 1998-2016 Zend Technologies
    with Zend OPcache v7.1.0-5+deb.sury.org~xenial+1, Copyright (c) 1999-2016, by Zend Technologies


.. meta::
    :description: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :keywords: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :author: Jasper Carpizo