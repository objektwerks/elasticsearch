package objektwerks

import com.sksamuel.elastic4s.ElasticDsl._
import com.sksamuel.elastic4s.{ElasticClient, ElasticProperties}
import com.sksamuel.elastic4s.fields.TextField
import com.sksamuel.elastic4s.http.JavaClient
import com.sksamuel.elastic4s.requests.common.RefreshPolicy

import com.typesafe.config.ConfigFactory

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class Elastic4sTest extends AnyFunSuite with Matchers {
  val conf = ConfigFactory.load("test.conf")
  val url = conf.getString("url")

  test("search") {
    val elasticProps = ElasticProperties(url)
    val client = ElasticClient( JavaClient(elasticProps) )

    // created index
    client.execute {
      createIndex("artists").mapping(
        properties(
          TextField("name")
        )
      )
    }.await

    // index into
    client.execute {
      indexInto("artists")
        .fields("name" -> "led zeppelin")
        .refresh(RefreshPolicy.WAIT_FOR)
    }.await

    // search
    val response = client.execute {
      search("artists").matchQuery("name", "led zeppelin")
    }.await
    println(response.result.hits.hits.head.sourceAsString)

    client.close()
  }
}