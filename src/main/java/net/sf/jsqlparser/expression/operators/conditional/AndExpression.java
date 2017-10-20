/*
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2013 JSQLParser
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
package net.sf.jsqlparser.expression.operators.conditional;

import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.ExpressionVisitor;

public class AndExpression extends BinaryExpression {

    private String operator;

    public AndExpression() {
        setOperator("AND");
    }

    public AndExpression(Expression leftExpression, Expression rightExpression) {
	    this(leftExpression, rightExpression, "AND");
	}

	public AndExpression(Expression leftExpression, Expression rightExpression, String operator) {
		setLeftExpression(leftExpression);
		setRightExpression(rightExpression);
		setOperator(operator.toUpperCase());
	}

	public String getOperator() {
	    return operator;
	}

	public void setOperator(String operator) {
	    this.operator = operator;
	}

	@Override
	public void accept(ExpressionVisitor expressionVisitor) {
		expressionVisitor.visit(this);
	}

	@Override
	public String getStringExpression() {
		return operator;
	}
}
