package com.mohress.edp.security;

import com.google.common.collect.ImmutableSet;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by youtao.wan on 2017/6/11.
 */
public class ResourceAccessDecisionServiceTest {

    private ResourceAccessDecisionService decisionService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init(){
        RoleVoter voter = new RoleVoter();
        voter.setRolePrefix("AUTH_");
        decisionService = new ResourceAccessDecisionService(voter);
    }

    @Test
    public void TestDecide_Success(){
        Authentication authenticationMock = mock(Authentication.class);
        FilterInvocation invocationMock = mock(FilterInvocation.class);
        ConfigAttribute attributeMock = mock(ConfigAttribute.class);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                GrantedAuthority authority = new SimpleGrantedAuthority("AUTH_STUDENT_QUERY");
                GrantedAuthority authority1 = new SimpleGrantedAuthority("AUTH_TEACHER_QUERY");
                return ImmutableSet.of(authority, authority1);
            }
        }).when(authenticationMock).getAuthorities();

        when(attributeMock.getAttribute()).thenReturn("AUTH_STUDENT_QUERY");

        decisionService.decide(authenticationMock, invocationMock, ImmutableSet.of(attributeMock));
    }

    @Test
    public void TestDecide_Fail(){
        Authentication authenticationMock = mock(Authentication.class);
        FilterInvocation invocationMock = mock(FilterInvocation.class);
        ConfigAttribute attributeMock = mock(ConfigAttribute.class);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                GrantedAuthority authority = new SimpleGrantedAuthority("AUTH_TEACHER_QUERY");
                return ImmutableSet.of(authority);
            }
        }).when(authenticationMock).getAuthorities();

        when(attributeMock.getAttribute()).thenReturn("AUTH_STUDENT_QUERY");

        thrown.expect(new AccessDeniedExceptionMatcher("用户无权限"));

        decisionService.decide(authenticationMock, invocationMock, ImmutableSet.of(attributeMock));
    }

    private static class AccessDeniedExceptionMatcher extends TypeSafeDiagnosingMatcher<AccessDeniedException>{

        private String message;

        public AccessDeniedExceptionMatcher(String message) {
            this.message = message;
        }

        @Override
        protected boolean matchesSafely(AccessDeniedException e, Description description) {
            return message.equals(e.getMessage());
        }

        @Override
        public void describeTo(Description description) {

        }
    }
}
