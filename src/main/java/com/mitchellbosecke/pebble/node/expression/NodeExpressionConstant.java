/*******************************************************************************
 * This file is part of Pebble.
 * 
 * Original work Copyright (c) 2009-2013 by the Twig Team
 * Modified work Copyright (c) 2013 by Mitchell Bösecke
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.mitchellbosecke.pebble.node.expression;

import com.mitchellbosecke.pebble.compiler.Compiler;
import com.mitchellbosecke.pebble.node.NodeExpression;
import com.mitchellbosecke.pebble.utils.TreeWriter;

public class NodeExpressionConstant extends NodeExpression {

	private final Object value;

	public NodeExpressionConstant(int lineNumber, Object value) {
		super(lineNumber);
		this.value = value;
	}

	@Override
	public void compile(Compiler compiler) {
		compiler.raw(String.valueOf(value));
	}
	
	public Object getValue(){
		return value;
	}
	
	@Override
	public void tree(TreeWriter tree) {
		tree.write(String.format("constant [%s]", String.valueOf(value)));
	}

}
