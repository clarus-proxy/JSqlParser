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

import net.sf.jsqlparser.statement.fetch.CursorFetch;

public class CursorFetchDeParser extends CursorOperationDeParser {

	/**
	 * StringBuilder (buffer parameter) as this object in order to work
	 * @param buffer the buffer that will be filled with the select
	 */
	public CursorFetchDeParser(StringBuilder buffer) {
		super(buffer);
	}

    public void deParse(CursorFetch cursorFetch) {
        buffer.append("FETCH ");
        super.deParse(cursorFetch);
    }
}
