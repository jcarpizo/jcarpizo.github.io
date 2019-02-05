Getting All Bus with Route Information
======================================

.. http:get:: /api/bus/

   **Example request**:

   .. sourcecode:: http

      GET /api/bus/ HTTP/1.1
      Host: localhost
      Accept: application/json, text/javascript

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Vary: Accept
      Content-Type: text/javascript

      [
        {
          "id" : "455a85e4-eb90-42db-b306-d5d70d298706"
          "arrival": "2017-12-01 00:00:0",
          "class": "Hilux",
          "departure": "2017-12-01 00:00:0",
          "destination": "Makati",
          "fare": "100",
          "name": "Solid North",
          "origin": "Davao",
          "created_at": "2018-06-24 14:31:32",
          "updated_at":"2018-06-24 14:31:32",
          "deleted_at": null
        },
        {
          "id" : "455a85e4-eb90-42db-b306-d5d70d298706"
          "arrival": "2017-12-01 00:00:0",
          "class": "Hilux",
          "departure": "2017-12-01 00:00:0",
          "destination": "Makati",
          "fare": "100",
          "name": "Solid North",
          "origin": "Davao",
          "created_at": "2018-06-24 14:31:32",
          "updated_at":"2018-06-24 14:31:32",
          "deleted_at": null
        }
      ]

   :reqheader Authorization: optional OAuth token to authenticate
   :resheader Content-Type: this depends on :mailheader:`Accept` of request
   :statuscode 200: no error
   :statuscode 404: there's record




Create Bus Service Location
===========================

.. http:post:: /api/bus/create

   **Example request**:

   .. sourcecode:: http

      POST /api/bus/create HTTP/1.1
      Host: localhost
      Accept: application/json, text/javascript

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Vary: Accept
      Content-Type: text/javascript

      [
        {
          "id" : "455a85e4-eb90-42db-b306-d5d70d298706"
          "arrival": "2017-12-01 00:00:0",
          "class": "Hilux",
          "departure": "2017-12-01 00:00:0",
          "destination": "Makati",
          "fare": "100",
          "name": "Solid North",
          "origin": "Davao",
          "created_at": "2018-06-24 14:31:32",
          "updated_at":"2018-06-24 14:31:32",
          "deleted_at": null
        }
      ]

   :query string name: the name of the bus
   :query datetime departure: the departure arrival of the bus
   :query datetime arrival: the datetime arrival of the bus
   :query string class: the type of bus
   :query number fare: the bus fare
   :query string origin: the bus origin route
   :query string destination: the destination route

   :reqheader Authorization: optional OAuth token to authenticate
   :resheader Content-Type: this depends on :mailheader:`Accept` of request
   :statuscode 200: no error
   :statuscode 404: there's no record



Update Bus Service Location
===========================

.. http:put:: /api/bus/update/(string:id)

   The bus (`id`) is a Uuid string.

   **Example request**:

   .. sourcecode:: http

      PUT /api/bus/update/(string:id) HTTP/1.1
      Host: localhost
      Accept: application/json, text/javascript

   **Example response**:

   .. sourcecode:: http

      HTTP/1.1 200 OK
      Vary: Accept
      Content-Type: text/javascript

      [
        {
          "id" : "455a85e4-eb90-42db-b306-d5d70d298706"
          "arrival": "2017-12-01 00:00:0",
          "class": "Hilux",
          "departure": "2017-12-01 00:00:0",
          "destination": "Makati",
          "fare": "100",
          "name": "Solid North",
          "origin": "Davao",
          "created_at": "2018-06-24 14:31:32",
          "updated_at":"2018-06-24 14:31:32",
          "deleted_at": null
        }
      ]

   :query string name: the name of the bus
   :query datetime departure: the departure arrival of the bus
   :query datetime arrival: the datetime arrival of the bus
   :query string class: the type of bus
   :query number fare: the bus fare
   :query string origin: the bus origin route
   :query string destination: the destination route

   :reqheader Authorization: optional OAuth token to authenticate
   :resheader Content-Type: this depends on :mailheader:`Accept` of request
   :statuscode 200: no error
   :statuscode 404: there's no record



Delete Bus Service Location
===========================

.. http:delete:: /api/bus/delete/(string:id)

    The bus (`id`) is a Uuid string.

   **Example request**:

   .. sourcecode:: http

      DELETE /api/bus/delete/(string:id) HTTP/1.1
      Host: localhost
      Accept: application/json, text/javascript


   :reqheader Authorization: optional OAuth token to authenticate
   :resheader Content-Type: this depends on :mailheader:`Accept` of request
   :statuscode 200: no error
   :statuscode 404: there's no record