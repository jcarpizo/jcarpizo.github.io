Adwords API Reporting
=====================

====================================================
Download a Criteria Performance Report with Selector
====================================================

.. code-block:: php
    :linenos:

    /**
    * Copyright 2017 Google Inc. All Rights Reserved.
    *
    * Licensed under the Apache License, Version 2.0 (the "License");
    * you may not use this file except in compliance with the License.
    * You may obtain a copy of the License at
    *
    *     http://www.apache.org/licenses/LICENSE-2.0
    *
    * Unless required by applicable law or agreed to in writing, software
    * distributed under the License is distributed on an "AS IS" BASIS,
    * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    * See the License for the specific language governing permissions and
    * limitations under the License.
    */
    namespace Google\AdsApi\Examples\AdWords\v201710\Reporting;

    require __DIR__ . '/../../../../vendor/autoload.php';

    use Google\AdsApi\AdWords\AdWordsSession;
    use Google\AdsApi\AdWords\AdWordsSessionBuilder;
    use Google\AdsApi\AdWords\Reporting\v201710\DownloadFormat;
    use Google\AdsApi\AdWords\Reporting\v201710\ReportDefinition;
    use Google\AdsApi\AdWords\Reporting\v201710\ReportDefinitionDateRangeType;
    use Google\AdsApi\AdWords\Reporting\v201710\ReportDownloader;
    use Google\AdsApi\AdWords\ReportSettingsBuilder;
    use Google\AdsApi\AdWords\v201710\cm\Predicate;
    use Google\AdsApi\AdWords\v201710\cm\PredicateOperator;
    use Google\AdsApi\AdWords\v201710\cm\ReportDefinitionReportType;
    use Google\AdsApi\AdWords\v201710\cm\Selector;
    use Google\AdsApi\Common\OAuth2TokenBuilder;

    /**
    * Downloads CRITERIA_PERFORMANCE_REPORT for the specified client customer ID.
    */
    class DownloadCriteriaReportWithSelector
    {

        public static function runExample(AdWordsSession $session, $filePath)
        {
        // Create selector.
            $selector = new Selector();
            $selector->setFields(['CampaignId', 'AdGroupId', 'Id', 'Criteria',
            'CriteriaType', 'Impressions', 'Clicks', 'Cost']);

        // Use a predicate to filter out paused criteria (this is optional).
            $selector->setPredicates([
            new Predicate('Status', PredicateOperator::NOT_IN, ['PAUSED'])]);

        // Create report definition.
            $reportDefinition = new ReportDefinition();
            $reportDefinition->setSelector($selector);
            $reportDefinition->setReportName(
                'Criteria performance report #' . uniqid()
            );
            $reportDefinition->setDateRangeType(
                ReportDefinitionDateRangeType::LAST_7_DAYS
            );
            $reportDefinition->setReportType(
                ReportDefinitionReportType::CRITERIA_PERFORMANCE_REPORT
            );
            $reportDefinition->setDownloadFormat(DownloadFormat::CSV);

        // Download report.
            $reportDownloader = new ReportDownloader($session);
        // Optional: If you need to adjust report settings just for this one
        // request, you can create and supply the settings override here. Otherwise,
        // default values from the configuration file (adsapi_php.ini) are used.
            $reportSettingsOverride = (new ReportSettingsBuilder())
            ->includeZeroImpressions(false)
            ->build();
            $reportDownloadResult = $reportDownloader->downloadReport(
                $reportDefinition,
                $reportSettingsOverride
            );
            $reportDownloadResult->saveToFile($filePath);
            printf(
                "Report with name '%s' was downloaded to '%s'.\n",
                $reportDefinition->getReportName(),
                $filePath
            );
        }

        public static function main()
        {
        // Generate a refreshable OAuth2 credential for authentication.
            $oAuth2Credential = (new OAuth2TokenBuilder())
            ->fromFile()
            ->build();

        // See: AdWordsSessionBuilder for setting a client customer ID that is
        // different from that specified in your adsapi_php.ini file.
        // Construct an API session configured from a properties file and the OAuth2
        // credentials above.
            $session = (new AdWordsSessionBuilder())
            ->fromFile()
            ->withOAuth2Credential($oAuth2Credential)
            ->build();

            $filePath = sprintf(
                '%s.csv',
                tempnam(sys_get_temp_dir(), 'criteria-report-')
            );
            self::runExample($session, $filePath);
        }
    }

    DownloadCriteriaReportWithSelector::main();




`https://developers.google.com/adwords/api/docs/appendix/reports/campaign-performance-report`_.

.. _https://developers.google.com/adwords/api/docs/appendix/reports/campaign-performance-report: https://developers.google.com/adwords/api/docs/appendix/reports/campaign-performance-report

`https://developers.google.com/adwords/api/docs/samples/php/reporting#download-a-criteria-performance-report-with-selector`_

.. _https://developers.google.com/adwords/api/docs/samples/php/reporting#download-a-criteria-performance-report-with-selector: https://developers.google.com/adwords/api/docs/samples/php/reporting#download-a-criteria-performance-report-with-selector

.. meta::
    :description: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :keywords: PHP 5.4.15+ with PHP Unit testing - Object Oriented Programming in PHP / RESTful API’s ,PHP Code Sniffer for checking coding compliance / PSR-2 standard coding style ,MVC PHP Framework – Symfony , Laravel, CakePHP and Phalcon,Docker Engine / Docker Hub,Guzzle, PHP HTTP Client,Auth0's API authorization,Google API, Twillio API, and Facebook API Integration,Object Relational Mapper (ORM) / Doctrine Query Language,JAVA Programming (J2SE),Angular JS 1 / 2 with Protractor End to End Tesing for Angular- JavaScript’s Framework,Joomla, Wordpress and Drupal ( Content Management System ), Adobe Flex PHP / Adobe ColdFusion, Unix Shell Scripting in Unix / Linux Environment,Twitter Bootstrap / Foundation,Grunt: The JavaScript Task Runner ,Qunit Javascript Unit Testing,Python 2.7.10 ,Highcharts JS ,Node JS, React JS, Vue JS, JQuery, and Navtive Javascript ,eJabberd XMPP Server ,Bitbuket with Pipeline Build Integration ,GitLab with Gitlab CI integration ,Git with Git Flow Integration ,MS SQL Enterprise ,MySQL with MySql Workbench and Sequel Pro, Postgre SQL,Composer for PHP dependencies,WebPack Node JS for JavaScript and Css dependencies ,Solaris 10 / Ubuntu 16.04 / Fedora 18 / Backtrack / Mac OS X – Unix and Linux OS ,Windows XP, Vista, 7 and 8 ,VMware Server / Virtual Box / Homestead ,HTML5, CSS and SASS ,SPHINX - Python Documentation Generator ,Sample API docs for mobile dev - Leaders Summit API Docs.
    :author: Jasper Carpizo