package JDBC_Hondenuitlaat.project.database;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class MockDBAccess extends DBAccess{
    private final MockPreparedStatement ps;

    public MockDBAccess(MockPreparedStatement ps) {
        super("", "", "");
        this.ps = ps;
    }

    @Override
    public Connection getConnection() {
        return new MockConnection(ps);
    }
}

