package callgraph;

import cymbol.CymbolBaseListener;
import cymbol.CymbolParser;

public class CallGraphListener extends CymbolBaseListener {
    private Graph graph = new Graph();
    String currentFunctionName = null; // 当前处理的函数名

    @Override
    public void enterFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
        currentFunctionName = ctx.ID().getText();
        graph.addNode(currentFunctionName);
    }

    @Override
    public void enterCall(CymbolParser.CallContext ctx) {
        graph.addEdge(currentFunctionName, ctx.ID().getText());
    }

    public Graph getGraph() {
        return graph;
    }
}
