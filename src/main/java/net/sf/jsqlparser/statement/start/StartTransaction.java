/*
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2015 JSQLParser
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */
/*
 * Copyright (C) 2015 JSQLParser.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package net.sf.jsqlparser.statement.start;

import java.util.List;

import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;

/**
 *
 * @author toben
 */
public class StartTransaction implements Statement {

    private String command;
    private String keyword;
    private List<String> transactionModes;
    private boolean commas;

    public StartTransaction(List<String> transactionModes) {
        this("START TRANSACTION", null, transactionModes);
    }

    public StartTransaction(String command, String keyword, List<String> transactionModes) {
        this(command, keyword, transactionModes, false);
    }

    public StartTransaction(String command, String keyword, List<String> transactionModes, boolean commas) {
        this.command = command;
        this.keyword = keyword;
        this.transactionModes = transactionModes;
        this.commas = commas;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getTransactionModes() {
        return transactionModes;
    }

    public void setTransactionModes(List<String> transactionModes) {
        this.transactionModes = transactionModes;
    }

    public boolean hasCommas() {
        return commas;
    }

    public void setCommas(boolean commas) {
        this.commas = commas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(command);
        if (keyword != null) {
            sb.append(' ').append(keyword);
        }
        if (transactionModes != null) {
            boolean first = true;
            for (String transactionMode : transactionModes) {
                if (first) {
                    first = false;
                } else if (commas) {
                    sb.append(',');
                }
                sb.append(' ').append(transactionMode);
            }
        }
        return sb.toString();
    }

    @Override
    public void accept(StatementVisitor statementVisitor) {
        statementVisitor.visit(this);
    }
}
