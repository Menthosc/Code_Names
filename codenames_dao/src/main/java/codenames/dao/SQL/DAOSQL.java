package codenames.dao.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAOSQL {

	
	/// Connection
	
	protected Connection connection = null;

	public void connect() throws SQLException {

		if (this.connection == null) {

			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codes_names?serverTimezone=UTC", "root",
					"");
			java.sql.Statement myStatement = this.connection.createStatement();

		}

	}

}
