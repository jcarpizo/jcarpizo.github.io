Git Flow Integration
====================

git-flow are a set of git extensions to provide high-level repository operations for Vincent Driessen's branching mode\

**Git-flow is a merge based solution. It doesn't rebase feature branches.**

=====
Setup
=====

.. code-block:: console


    apt-get install git-flow

===============
Getting started
===============

Git flow needs to be initialized in order to customize your project setup.

Initialize
----------

Start using git-flow by initializing it inside an existing git repository:

.. code-block:: console

    git flow init

You'll have to answer a few questions regarding the naming conventions for your branches.
It's recommended to use the default values.

========
Features
========

**Develop new features for upcoming releases**
**Typically exist in developers repos only**

Start a new feature
-------------------

Development of new features starting from the 'develop' branch.

Start developing a new feature with

.. code-block:: console

   git flow feature start MYFEATURE


This action creates a new feature branch based on 'develop' and switches to it

Finish up a feature
-------------------

Finish the development of a feature. This action performs the following

**Merges MYFEATURE into 'develop'**
**Removes the feature branch**
**Switches back to 'develop' branch**


.. code-block:: console

    git flow feature finish MYFEATURE


Publish a feature
-----------------

Are you developing a feature in collaboration?
Publish a feature to the remote server so it can be used by other users.


.. code-block:: console

    git flow feature publish MYFEATURE



Getting a published feature
---------------------------

Get a feature published by another user.


.. code-block:: console

   git flow feature pull origin MYFEATURE

You can track a feature on origin by using


.. code-block:: console

   using git flow feature track MYFEATURE


==============
Make a release
==============

**Support preparation of a new production release**
**Allow for minor bug fixes and preparing meta-data for a release**

Start a release
---------------

To start a release, use the git flow release command. It creates a release branch created from the 'develop' branch.

.. code-block:: console

   git flow release start RELEASE [BASE]

You can optionally supply a **[BASE]** commit sha-1 hash to start the release from. The commit must be on the 'develop' branch.

It's wise to publish the release branch after creating it to allow release commits by other developers. Do it similar to feature publishing with the command:

.. code-block:: console

   git flow release publish RELEASE


(You can track a remote release with the command

.. code-block:: console

   git flow release track RELEASE


Finish up a release
-------------------

Finishing a release is one of the big steps in git branching. It performs several actions:

**Merges the release branch back into 'master'**
**Tags the release with its name**
**Back-merges the release into 'develop'**
**Removes the release branch**

.. code-block:: console

   git flow release finish RELEASE

Don't forget to push your tags with

.. code-block:: console

   git push --tags


========
Hotfixes
========

**Hotfixes arise from the necessity to act immediately upon an undesired state of a live production version**
**May be branched off from the corresponding tag on the master branch that marks the production version.**

Git flow hotfix start
---------------------

Like the other git flow commands, a hotfix is started with

.. code-block:: console

  git flow hotfix start VERSION [BASENAME]


The version argument hereby marks the new hotfix release name. Optionally you can specify a basename to start from.

Finish a hotfix
---------------

By finishing a hotfix it gets merged back into develop and master. Additionally the master merge is tagged with the hotfix version.

.. code-block:: console

  git flow hotfix finish VERSION


.. meta::
    :description: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :keywords: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :author: Jasper Carpizo