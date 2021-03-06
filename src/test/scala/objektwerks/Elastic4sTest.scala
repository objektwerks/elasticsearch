package objektwerks

import com.sksamuel.elastic4s.http.ElasticDsl._
import com.sksamuel.elastic4s.http.{ElasticClient, ElasticProperties, Response}
import com.sksamuel.elastic4s.http.search.SearchResponse
import com.sksamuel.elastic4s.requests.common.RefreshPolicy
import com.typesafe.config.ConfigFactory

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

// Symbol 'type com.sksamuel.elastic4s.searches.queries.term.BuildableTermsQuery'
// is missing from the classpath.
class Elastic4sTest extends AnyFunSuite with Matchers {
  val conf = ConfigFactory.load("test.conf")
  val url = conf.getString("url")

  test("search") {
    val client = ElasticClient(ElasticProperties(url))

    client.execute {
      indexInto("bands" / "artists")
        .fields ("name" -> "coldplay")
        .refresh (RefreshPolicy.WAIT_FOR)
    }.await  // No implicit arguments of type: Handler[SearchRequest, U_]

    val response: Response[SearchResponse] = client.execute {
      search("bands")
        .matchQuery("name", "coldplay")
    }.await  // No implicit arguments of type: Handler[SearchRequest, U_]

    println(response.result.hits.hits.head.sourceAsString)
    client.close()
  }
}