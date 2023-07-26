package me.study.jpa.thread;

import me.study.jpa.channel.Channel;
import me.study.jpa.channel.ChannelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class ThreadRepositoryTest {
    @Autowired
    private ThreadRepository threadRepository;
    @Autowired
    private ChannelRepository channelRepository;

    @Test
    void insertSelectThreadTest() { // 제대로 저장하는지를 테스트
        // given
        var newChannel = Channel.builder().name("new-group").build();
        var newThread = Thread.builder().message("new-message").build();
        var newThread2 = Thread.builder().message("new-message2").build();
        newThread.setChannel(newChannel);
        newThread2.setChannel(newChannel);

        // when
        var savedChannel = channelRepository.insertChannel(newChannel);
        var savedThread = threadRepository.insertThread(newThread);
        var savedThread2 = threadRepository.insertThread(newThread2);

        // then
        var foundChannel = channelRepository.selectChannel(savedChannel.getId());
        assert foundChannel.getThreads().containsAll(Set.of(savedThread, savedThread2));
    }
}
