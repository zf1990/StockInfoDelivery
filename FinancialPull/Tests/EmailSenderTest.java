import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailSenderTest {


	@Test
	void testEmailSenderStringString() {
		EmailSender sender = new EmailSender("test.csv", "zfang1216@gmail.com");
		assertTrue(sender.SuccessfullySent);
	}

	@Test
	void testEmailSenderStringStringandMsg() {
		EmailSender sender = new EmailSender("test.csv", "zfang1216@gmail.com","test message");
		assertTrue(sender.SuccessfullySent);
	}
	
//	@Test
//	void testEmailSenderStringStringString() {
//		fail("Not yet implemented");
//	}

}
