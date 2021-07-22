ElasticSearch
-------------
>Elasticsearch feature tests.

Warning
-------
>The Elastic4sTest is broken due to a missing dependency issue.
>See source for details ( https://github.com/objektwerks/elasticsearch/blob/master/src/test/scala/objektwerks/Elastic4sTest.scala ).

Install
-------
1. brew install elasticsearch

Run
---
1. brew services start elasticsearch

Test
----
1. sbt clean test
