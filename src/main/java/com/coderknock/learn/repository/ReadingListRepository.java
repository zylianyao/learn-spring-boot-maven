package com.coderknock.learn.repository;

import com.coderknock.learn.entity.Book;
import com.coderknock.learn.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 拿客
 * 网站：www.coderknock.com
 * QQ群：213732117
 * 三产 创建于 2016年10月26日 10:18:28。
 * 描述：
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {//通过扩展JpaRepository，ReadingListRepository直接继承了18个执行常用持久化操作的方法。JpaRepository是个泛型接口，有两个参数：仓库操作的领域对象类型，及其ID属性的 类型。Spring Data提供了很神奇的魔法，只需定义仓库接口，在应用程序启动后，该接口在运行时会自动实现。

    /**
     * 通过读者查询书籍
     *
     * @param reader
     * @return
     */
    List<Book> findByReader(Reader reader);

}
