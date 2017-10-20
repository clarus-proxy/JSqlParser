/*
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2014 JSQLParser
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
package net.sf.jsqlparser.expression;

import java.util.List;

/**
 *
 * @author toben
 */
public class Alias {

	private String name;
	private boolean useAs = true;
	private List<String> attributes;

	public Alias(String name) {
		this.name = name;
	}
	
	public Alias(String name, boolean useAs) {
		this.name = name;
		this.useAs = useAs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isUseAs() {
		return useAs;
	}

	public void setUseAs(boolean useAs) {
		this.useAs = useAs;
	}

	public List<String> getAttributes() {
	    return attributes;
	}

        public void setAttributes(List<String> attributes) {
            this.attributes = attributes;
        }

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder(" ");
	    if (useAs)
	        sb.append("AS ");
	    sb.append(name);
	    if (attributes != null) {
	        sb.append('(');
	        int i = 0;
	        for (String attribute : attributes) {
	            if (i > 0) {
	                sb.append(", ");
	            }
	            sb.append(attribute);
	            i ++;
                }
                sb.append(')');
	    }
	    return sb.toString();
	}
}
