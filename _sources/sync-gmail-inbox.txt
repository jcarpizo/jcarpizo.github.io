Synchronized GMail Inbox [PHP]
==============================

.. code-block:: php
    :linenos:

    use Carbon\Carbon;
    use Illuminate\Console\Command;

    class GMailSync extends Command
    {

        private $mailService;
        /**
         * The name and signature of the console command.
         *
         * @var string
         */
        protected $signature = 'google:sync-email';

        /**
         * The console command description.
         *
         * @var string
         */
        protected $description = 'Run to synchronize google emails';

        /**
         * Create a new command instance.
         *
         * @return void
         */
        public function __construct(GMailServiceInterface $mailService)
        {
            parent::__construct();
            $this->mailService = $mailService;
        }

        /**
         * Execute the console command.
         *
         * @return mixed
         */
        public function handle()
        {
            $client = $this->getClient();
            $service = new \Google_Service_Gmail($client);
            $user = 'me';
            $opt_param = ['labelIds' => 'INBOX'];
            $messages = $service->users_messages->listUsersMessages($user, $opt_param);
            $bar = $this->output->createProgressBar(count($messages));
            foreach ($messages as $key => $message) {
                $message = $service->users_messages->get($user, $message->getId(), ['format' => 'full']);
                $this->mailService->create([
                    'email_id' => $message->getId(),
                    'snippet' => $message->getSnippet(),
                    'headers' => json_encode($message->getPayload()->getHeaders()),
                    'body' => (!empty($message->getPayload()->getBody()->getData()) ?
                        $message->getPayload()->getBody()->getData() : $message->getPayload()->getParts()[1]->body->data),
                    'internal_date' => Carbon::createFromTimestamp($message->getInternalDate() / 1000)
                        ->toDateTimeString()
                ]);

                $bar->advance();
            }
            $bar->finish();
        }

        private function googleScopes()
        {
            return implode(' ', [
                \Google_Service_Gmail::MAIL_GOOGLE_COM,
            ]);
        }

        private function getClient()
        {
            $client = new \Google_Client();
            $client->setApplicationName(getenv('APP_NAME'));
            $client->setScopes($this->googleScopes());
            $client->setAuthConfig(__DIR__ . '/../../../.credentials/gmail_client.json');
            $client->setAccessType('offline');

            $credentialsPath = $this->expandHomeDirectory(__DIR__ . '/../../../.credentials/gmail_token.json');
            if (file_exists($credentialsPath)) {
                $accessToken = json_decode(file_get_contents($credentialsPath), true);
            } else {
                $authUrl = $client->createAuthUrl();
                printf("Open the following link in your browser:\n%s\n", $authUrl);
                print 'Enter verification code: ';
                $authCode = trim(fgets(STDIN));

                $accessToken = $client->fetchAccessTokenWithAuthCode($authCode);

                if (!file_exists(dirname($credentialsPath))) {
                    mkdir(dirname($credentialsPath), 0700, true);
                }
                file_put_contents($credentialsPath, json_encode($accessToken));
                printf("Credentials saved to %s\n", $credentialsPath);
            }
            $client->setAccessToken($accessToken);

            if ($client->isAccessTokenExpired()) {
                $client->fetchAccessTokenWithRefreshToken($client->getRefreshToken());
                file_put_contents($credentialsPath, json_encode($client->getAccessToken()));
            }
            return $client;
        }

        private function expandHomeDirectory($path)
        {
            $homeDirectory = getenv('HOME');
            if (empty($homeDirectory)) {
                $homeDirectory = getenv('HOMEDRIVE') . getenv('HOMEPATH');
            }
            return str_replace('~', realpath($homeDirectory), $path);
        }
    }

`https://developers.google.com/gmail/api/quickstart/php`_.

.. _https://developers.google.com/gmail/api/quickstart/php: https://developers.google.com/gmail/api/quickstart/php

.. meta::
    :description: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :keywords: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :author: Jasper Carpizo