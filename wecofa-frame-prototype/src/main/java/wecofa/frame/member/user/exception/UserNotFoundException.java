package wecofa.frame.member.user.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String userId){
        super(userId+ "NotFoundException");
    }
}
