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
package net.sf.jsqlparser.util.deparser;

import net.sf.jsqlparser.statement.StatementVisitor;
import net.sf.jsqlparser.statement.declare.cursor.DeclareCursor;

public class DeclareCursorDeParser {

	private StringBuilder buffer;
    private StatementVisitor statementVisitor;

	/**
	 * StringBuilder (buffer parameter) as this object in order to work
	 * @param buffer the buffer that will be filled with the select
	 */
	public DeclareCursorDeParser(StatementVisitor statementVisitor, StringBuilder buffer) {
		this.buffer = buffer;
		this.statementVisitor = statementVisitor;
	}

	public StringBuilder getBuffer() {
		return buffer;
	}

	public void setBuffer(StringBuilder buffer) {
		this.buffer = buffer;
	}

	public void deParse(DeclareCursor declareCursor) {
		buffer.append("DECLARE ");
		buffer.append(declareCursor.getName()).append(' ');
		if (declareCursor.isBinary()) {
	        buffer.append("BINARY ");
		}
        if (declareCursor.isInsensitive()) {
            buffer.append("INSENSITIVE ");
        }
        if (declareCursor.getScroll() != null) {
            if (declareCursor.getScroll() == false) {
                buffer.append("NO ");
            }
            buffer.append("SCROLL ");
        }
        buffer.append("CURSOR ");
        if (declareCursor.getHold() != null) {
            if (declareCursor.getHold()) {
                buffer.append("WITH ");
            } else {
                buffer.append("WITHOUT ");
            }
            buffer.append("HOLD ");
        }
        buffer.append("FOR ");
        declareCursor.getQuery().accept(statementVisitor);
	}

	public StatementVisitor getStatementVisitor() {
        return statementVisitor;
    }

    public void setStatementVisitor(StatementVisitor statementVisitor) {
        this.statementVisitor = statementVisitor;
    }
}
