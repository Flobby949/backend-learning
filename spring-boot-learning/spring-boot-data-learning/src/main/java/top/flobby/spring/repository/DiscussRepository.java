package top.flobby.spring.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.flobby.spring.domain.Discuss;

import java.util.List;

/**
 * @author : JinChenXing
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-20 14:16
 **/

public interface DiscussRepository extends JpaRepository<Discuss, Integer> {

    /**
     * 查询作者不为空的评论列表
     * @return {@link List}<{@link Discuss}>
     */
    List<Discuss> findByAuthorNotNull();

    /**
     * 评论内容模糊查询
     * 使用 JPA 方法名关键字进行查询
     * @param content 内容
     * @return {@link List}<{@link Discuss}>
     */
    List<Discuss> findByContentLike(String content);

    /**
     * 文章id
     * 注意映射
     * @param aId 文章id
     * @return {@link List}<{@link Discuss}>
     */
    List<Discuss> findByAIdEquals(Integer aId);


    /**
     * 分页查询，使用query注解进行查询
     * JPQL 查询
     * 原生SQL查询
     *
     * @param pageable 分页
     * @param aId      文章Id
     * @return {@link List}<{@link Discuss}>
     */
    @Query("SELECT c FROM t_comment c WHERE c.AId = ?1 ")
    // @Query(value = "SELECT * FROM t_comment WHERE a_id = ?1 ", nativeQuery = true)
    List<Discuss> selectByPage(Integer aId, Pageable pageable);
}
