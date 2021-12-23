ElasticSearch
-------------
>Elasticsearch feature tests.

Apple M1
--------
>See ( https://stackoverflow.com/questions/70455469/brew-install-elasticsearch-on-m1-macbook-results-in-bad-cpu-type-in-executable )

Download
--------
>See ( https://www.elastic.co/downloads/elasticsearch )

Install
-------
1. brew install elasticsearch
>or
1. brew tap elastic/tap
2. brew install elastic/tap/elasticsearch-full

Run
---
1. brew services start elasticsearch

Test
----
1. sbt clean test