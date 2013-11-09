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

public class NodeExpressionVariableName extends NodeExpression {

	protected final String name;

	public NodeExpressionVariableName(int lineNumber, String name) {
		super(lineNumber);
		this.name = name;
	}

	@Override
	public void compile(Compiler compiler) {
		if("_self".equals(name)){
			compiler.raw("this");
		}else{
			compiler.raw("context.get(").string(name).raw(")");
		}
	}

	public String getName(){
		return name;
	}
	
	public void tree(TreeWriter tree){
		tree.write(String.format("variable name [%s]", name));
	}
}
