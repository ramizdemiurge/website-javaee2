package repository;

import entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article,Long>
{

    @Query("select b from Article b where b.id = :id")
    Article findById(@Param("id") long id);
}
