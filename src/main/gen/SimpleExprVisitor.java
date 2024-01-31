// Generated from //wsl$/Ubuntu-22.04/home/dusker/compiler-2023-nju-ant/compilers-coding/src/main/antlr/simpleExpr\SimpleExpr.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SimpleExprParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(SimpleExprParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SimpleExprParser.ExprContext ctx);
}