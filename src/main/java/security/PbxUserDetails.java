//package security;
//
//import entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
//public class PbxUserDetails implements UserDetails
//{
//
//    private final User user;
//
//    public PbxUserDetails(final User user)
//    {
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities()
//    {
//        Set<GrantedAuthority> authorities = new HashSet<>();
//
//        //authorities.add((GrantedAuthority) () -> getUser().getRole().name());
//
//        return authorities;
//    }
//
//    @Override
//    public String getPassword()
//    {
//        return getUser().getPassword();
//    }
//
//    @Override
//    public String getUsername()
//    {
//        return getUser().getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired()
//    {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked()
//    {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired()
//    {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled()
//    {
//        return user != null && user.isEnabled();
//    }
//
//
//    public User getUser()
//    {
//        return user;
//    }
//
//}
