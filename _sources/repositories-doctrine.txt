Using Repositories in Doctrine 2
================================

One feature of Doctrine 2 and other data mapper style ORM’s is that rather than each class model invoking itself to make queries in the database (Active Record style), custom queries to the database are handled by a bridge layer that is extends the Entity Manager.

We cannot do any any queries to the DB without going through the Entity Manager, here is the simplest case:

.. code-block:: php

    $user = $em->find('Entities\User', $id);

But more often than not we will need to go through a repository for that model, in the Java world these are often referred to as Data Access Objects or DAO’s. Again a simple example would look like the following:


.. code-block:: php

    $user = $em->getRepository('Entities\User')->find($id);

Here the Entity Manager will look for the Repository which is attached to your Entity class. If you have not set this yet it will provide you with a default Repository class (Doctrine\ORM\EntityRepository) which contains the following methods for accessing your data:


.. code-block:: php

    public function findAll()
    public function findBy(array $criteria)
    public function findOneBy(array $criteria)


With these very simple methods you can get direct access to your data, but more than often this will not be enough. The default EntitiyRepository class contains

.. code-block:: php

    public function createQueryBuilder($alias)

Which you can probably just go ahead and use just like in the example above (I have never tried) in your controller etc, but this should not really be done, when you need the power of the query builder, DQL (Doctrine Query Language) or native SQL calls you should be writing these in your own repository class for the particular entity that you are using.

This will inherit Doctrine\ORM\EntityRepository:


.. code-block:: php

    namespace Repositories;

    use Doctrine\ORM\EntityRepository;
    use Entities;

    class UserRepository extends EntityRepository
    {
        public function finderMethod($arguments)
        {
            // My custom query etc
        }
    }

But you need to tell Doctrine now that you have created this repository. You can do that by the Driver Implementation type you are using(ie YAML/Annotations/XML). I use annotations and I highly recommend you do as it keeps everything in the same place. Here is how we do this in your entitiy class:


.. code-block:: php

    namespace Entities;

    /** @Entity(repositoryClass="Repositories\UserRepository")
     *  @Table(name="dealers")
     */
    class User

So now when you try and access your own custom finder method it will now all be lovely-jubbly!:

.. code-block:: php

    $users = $em->getRepository('Entities\User')->finderMethod($arguments);


Which you can add the following type of repository custome finder method:

.. code-block:: php

    public function findAuthenticatedUsersForDate($date)
    {

        // First get the EM handle
        // and call the query builder on it
        $qb = $this->_em->createQueryBuilder();
        $qb->select('u')
            ->from('Entities\User', 'u')
            ->where('u.authenticated = 1')
            ->andWhere('u.date = :date')
            ->setParameter('date', $date)
            ->orderBy('u.name');

        return $qb->getQuery()->getResult();
    }

I found the $qb->getQuery()->getResult(); explanations quite scarce, but you need to use them even if using DQL.

.. meta::
    :description: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :keywords: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :author: Jasper Carpizo