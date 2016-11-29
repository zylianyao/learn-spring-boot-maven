package com.coderknock.learn.controller;

import com.coderknock.learn.entity.Book;
import com.coderknock.learn.entity.Reader;
import com.coderknock.learn.properties.AmazonProperties;
import com.coderknock.learn.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 拿客
 * 网站：www.coderknock.com
 * QQ群：213732117
 * 三产 创建于 2016年10月26日 10:22:30。
 * 描述：
 */
@Controller
@RequestMapping("/")
public class ReadingListController {

    private AmazonProperties amazonProperties;

    private ReadingListRepository readingListRepository;

    private CounterService counterService;

    private GaugeService gaugeService;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, AmazonProperties amazonProperties, CounterService counterService, GaugeService gaugeService) {
        this.readingListRepository = readingListRepository;
        this.amazonProperties = amazonProperties;
        this.counterService = counterService;
        this.gaugeService = gaugeService;

    }

    /**
     * 获取读者的书籍列表
     *
     * @param reader
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(Reader reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonID", amazonProperties.getAssociateId());
        }
        return "readingList";
    }

    /**
     * 为书籍添加读者
     *
     * @param reader
     * @param book
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Reader reader, @Valid Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        //会添加前缀 counter.
        counterService.increment("books.saved");
        //会添加前缀 gauge.
        gaugeService.submit("books.last.saved", System.currentTimeMillis());

        return "redirect:/";
    }
}
