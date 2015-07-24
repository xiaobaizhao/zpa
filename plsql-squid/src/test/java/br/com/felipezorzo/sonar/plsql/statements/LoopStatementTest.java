package br.com.felipezorzo.sonar.plsql.statements;

import static org.sonar.sslr.tests.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.felipezorzo.sonar.plsql.api.PlSqlGrammar;
import br.com.felipezorzo.sonar.plsql.api.RuleTest;

public class LoopStatementTest extends RuleTest {

    @Before
    public void init() {
        setRootRule(PlSqlGrammar.LOOP_STATEMENT);
    }

    @Test
    public void matchesSimpleLoop() {
        assertThat(p).matches(""
                + "loop "
                + "null; "
                + "end loop;");
    }
    
    @Test
    public void matchesNestedLoop() {
        assertThat(p).matches(""
                + "loop "
                + "loop "
                + "null; "
                + "end loop; "
                + "end loop;");
    }
    
    @Test
    public void matchesLabeledLoop() {
        assertThat(p).matches(""
                + "<<foo>> loop "
                + "null; "
                + "end loop foo;");
    }

}
