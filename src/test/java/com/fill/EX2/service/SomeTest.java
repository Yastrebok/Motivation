package com.fill.EX2.service;

import com.fill.EX2.repository.UserRepository;
import org.junit.Before;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SomeTest {
    private static final Integer USER_ID = 1;
    @Mock
    public UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userService;
    @Captor
    private ArgumentCaptor<UserRepository.User> userArgumentCaptor;
    @Captor
    private ArgumentCaptor<Integer> userIdArgumentCaptor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);


    }

//    @Test
//    public void testSave() {
//        when(userRepository.save(userArgumentCaptor.capture()))
//                .thenReturn(USER_ID);
//
//        UserService.UserDto build = UserService.UserDto.builder().build();
//        result = userService.save(build);
//
//        assertEquals("", USER_ID, result);
//
//        assertUser();
//
//        verify(userRepository, times(1)).save(Matchers.any());
//        verifyNoMoreInteractions(userRepository);
//    }
//
//    @Test
//    void testGetById() {
//        Integer id = 1;
//        UserRepository.User result = UserRepository.User.builder().build();
//        when(userRepository.getById(userIdArgumentCaptor.capture()))
//                .thenReturn(result);
//
//        userService.getById(id);
//        assertEqauls("", id, userIdArgumentCaptor.getValue());
//    }
//
//    void asserUser(UserService.UserDto userDto, UserRepository.User user) {
//        assert(userDto.getId(), user.getId());
//    }
}
