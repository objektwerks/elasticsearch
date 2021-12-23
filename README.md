ElasticSearch
-------------
>Elasticsearch feature tests.

Warning
-------
>The Elastic4sTest is **broken** due to a missing dependency issue.
>See ( https://github.com/objektwerks/elasticsearch/blob/master/src/test/scala/objektwerks/Elastic4sTest.scala )

Apple M1
--------
>See ( https://stackoverflow.com/questions/70455469/brew-install-elasticsearch-on-m1-macbook-results-in-bad-cpu-type-in-executable )

Install
-------
1. brew install elasticsearch

Run
---
1. brew services start elasticsearch

Test
----
1. sbt clean test