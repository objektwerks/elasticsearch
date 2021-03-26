package objektwerks

import com.sksamuel.elastic4s.http.ElasticDsl._
import com.sksamuel.elastic4s.http.search.SearchResponse
import com.sksamuel.elastic4s.http._
import com.sksamuel.elastic4s.requests.common.RefreshPolicy

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class Elastic4sTest extends AnyFunSuite with Matchers {
  test("search") {
    val client = ElasticClient(ElasticProperties("http://localhost:9200"))

    client.execute {
      indexInto("bands" / "artists") fields ("name" -> "coldplay") refresh (RefreshPolicy.WAIT_FOR)
    }.await

    val response: Response[SearchResponse] = client.execute {
      search("bands") matchQuery("name", "coldplay")
    }.await

    println(response.result.hits.hits.head.sourceAsString)
    client.close()
  }
}