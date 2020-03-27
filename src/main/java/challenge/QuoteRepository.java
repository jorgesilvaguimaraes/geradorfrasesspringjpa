package challenge;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Integer> {

    @Query(value = "select * from scripts order by rand() limit 1", nativeQuery = true)
    Quote findQuote();

    @Query(value = "select * from scripts where actor = :actor order by rand() limit 1", nativeQuery = true)
    Quote findByActor(@Param("actor") String actor);


}
