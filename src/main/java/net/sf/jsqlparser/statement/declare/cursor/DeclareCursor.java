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
package net.sf.jsqlparser.statement.declare.cursor;

import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;
import net.sf.jsqlparser.statement.select.Select;

/**
 *
 * @author toben
 */
public class DeclareCursor implements Statement {

    private String name;
    private boolean binary;
    private boolean insensitive;
    private Boolean scroll;
    private Boolean hold;
    private Select query;

    public DeclareCursor(String name, Select query) {
        this(name, false, false, null, null, query);
    }

    public DeclareCursor(String name, boolean binary, boolean insensitive, Boolean scroll, Boolean hold, Select query) {
        this.name = name;
        this.binary = binary;
        this.insensitive = insensitive;
        this.scroll = scroll;
        this.hold = hold;
        this.query = query;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DECLARE ");
        sb.append(name).append(" ");
        if (binary) {
            sb.append("BINARY ");
        }
        if (insensitive) {
            sb.append("INSENSITIVE ");
        }
        if (scroll != null) {
            if (scroll == false) {
                sb.append("NO ");
            }
            sb.append("SCROLL ");
        }
        sb.append("CURSOR ");
        if (hold != null) {
            if (hold) {
                sb.append("WITH ");
            } else {
                sb.append("WITHOUT ");
            }
            sb.append("HOLD ");
        }
        sb.append("FOR ");
        sb.append(query.toString());
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBinary() {
        return binary;
    }

    public void setBinary(boolean binary) {
        this.binary = binary;
    }

    public boolean isInsensitive() {
        return insensitive;
    }

    public void setInsensitive(boolean insensitive) {
        this.insensitive = insensitive;
    }

    public Boolean getScroll() {
        return scroll;
    }

    public void setScroll(Boolean scroll) {
        this.scroll = scroll;
    }

    public Boolean getHold() {
        return hold;
    }

    public void setHold(Boolean hold) {
        this.hold = hold;
    }

    public Select getQuery() {
        return query;
    }

    public void setQuery(Select query) {
        this.query = query;
    }

    @Override
    public void accept(StatementVisitor statementVisitor) {
        statementVisitor.visit(this);
    }
}
