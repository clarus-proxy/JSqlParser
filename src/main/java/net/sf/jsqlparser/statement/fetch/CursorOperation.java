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
package net.sf.jsqlparser.statement.fetch;

import net.sf.jsqlparser.statement.Statement;

/**
 *
 * @author toben
 */
public abstract class CursorOperation implements Statement {

    private String name;
    private String direction;
    private Long count;
    private String fromIn;

    public CursorOperation(String name) {
        this(name, null, null, null);
    }

    public CursorOperation(String name, String direction, Long count, String fromIn) {
        this.name = name;
        this.direction = direction;
        this.count = count;
        this.fromIn = fromIn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getOperation()).append(' ');
        if (direction != null) {
            sb.append(direction).append(' ');
        }
        if (count != null) {
            sb.append(count).append(' ');
        }
        if (fromIn != null) {
            sb.append(fromIn).append(' ');
        }
        sb.append(name);
        return sb.toString();
    }

    public abstract String getOperation();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getFromIn() {
        return fromIn;
    }

    public void setFromIn(String fromIn) {
        this.fromIn = fromIn;
    }
}
