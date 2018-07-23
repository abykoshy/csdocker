package ak.dctm.csdocker;

import com.documentum.com.DfClientX;
import com.documentum.com.IDfClientX;
import com.documentum.fc.client.DfClient;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.client.IDfSessionManager;
import com.documentum.fc.common.DfLoginInfo;
import com.documentum.fc.common.IDfLoginInfo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalContentServerDockerConnectionTest {

    @Test
    public void testConnection() throws Exception{
        IDfLoginInfo dfLoginInfo = new DfLoginInfo();
        dfLoginInfo.setUser("dmadmin");
        dfLoginInfo.setPassword("password");
        IDfClientX clientX = new DfClientX();
        IDfSessionManager sessionManager = DfClient.getInstance().newSessionManager();
        sessionManager.setIdentity("DocbaseName", dfLoginInfo);
        IDfSession session = sessionManager.getSession("DocbaseName");
        assertThat(session.isConnected());
    }
}
