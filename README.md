ElasticSearch
-------------
>Elasticsearch feature tests.

Apple M1
--------
>See ( https://stackoverflow.com/questions/70455469/brew-install-elasticsearch-on-m1-macbook-results-in-bad-cpu-type-in-executable )

Install
-------
1. brew install elasticsearch
>or
1. brew tap elastic/tap
2. brew install elastic/tap/elasticsearch-full
>or
1. https://www.elastic.co/downloads/elasticsearch 

Run
---
1. brew services start elasticsearch
>or
1. ELASTIC_SEARCH_HOME/bin/elasticsearch   

Test
----
1. sbt clean test