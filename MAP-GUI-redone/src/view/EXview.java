package view;

import model.expression.*;
import model.myStack.MyStack;
import model.myStack.MyStackImplementation;
import model.operation.OperationsWithIntegerExpressions;
import model.operation.OperationsWithIntegers;
import model.operation.OperationsWithLogicValues;
import model.statements.*;
import model.type.BOOLtype;
import model.type.INTtype;
import model.type.REFtype;
import model.type.STRINGtype;
import model.value.BoolValue;
import model.value.IntValue;
import model.value.StringValue;

import javax.swing.plaf.nimbus.State;

public class EXview {
    /*EXAMPLE 1*/
    public static MyStack<Statement> getExampleOne(){
        // int v;
        // v=2;
        // Print(v)
        Statement firstStatement = new VariableDeclarationStatement("v",new INTtype());
        Statement secondStatement = new AssignStatement("v",new ValueExpression(new IntValue(2)));
        Statement thirdStatement = new PrintStatement(new VariableExpression("v"));
        MyStackImplementation<Statement> statements = new MyStackImplementation<Statement>();
        statements.push(thirdStatement);
        statements.push(secondStatement);
        statements.push(firstStatement);
        return statements;
    }
    public static String getTextExampleOne(){
        return new String("int v; \t  v = 2; \t Print(v);");
    }
    /*EXAMPLE 2*/
    public static MyStack<Statement> getExampleTwo(){
        //int a;
        //a=2+3*5;
        //int b;
        //b=a-4/2 + 7;
        //Print(b)
        Statement firstStatement = new VariableDeclarationStatement("a",new INTtype());
        Expression multiplication = new ArithmeticExpression(new ValueExpression(new IntValue(3)),new ValueExpression(new IntValue(5)),OperationsWithIntegers.MULTIPLICATION);
        Expression addition = new ArithmeticExpression(new ValueExpression(new IntValue(2)),multiplication,OperationsWithIntegers.SUM);
        Statement secondStatement = new AssignStatement("a",addition);
        Statement thirdStatement = new VariableDeclarationStatement("b",new INTtype());
        Expression division = new ArithmeticExpression(new ValueExpression(new IntValue(4)),new ValueExpression(new IntValue(2)),OperationsWithIntegers.DIVISION);
        Expression difference = new ArithmeticExpression(new VariableExpression("a"),division,OperationsWithIntegers.DIFFERENCE);
        Expression addition2 = new ArithmeticExpression(difference,new ValueExpression(new IntValue(7)),OperationsWithIntegers.SUM);
        Statement fourthStatement = new AssignStatement("b",addition2);
        Statement fifthStatement = new PrintStatement(new VariableExpression("b"));
        MyStackImplementation<Statement> statements = new MyStackImplementation<>();
        statements.push(fifthStatement);
        statements.push(fourthStatement);
        statements.push(thirdStatement);
        statements.push(secondStatement);
        statements.push(firstStatement);
        return statements;
    }
    public static String getTextExampleTwo(){
        return new String("int a; \t a = 2+3*5; \t int b; \t b = a-4/2+7; \t print(b);");
    }
    public static Statement getExampleThree(){
        //bool a;
        //a=true;
        //int v;
        //If a Then v=2 Else v=3;
        //Print(v)
        //System.out.println("EXAMPLE 3\n");
        return new CompoundStatement(new VariableDeclarationStatement("a",new BOOLtype()),
                new CompoundStatement(new VariableDeclarationStatement("v", new INTtype()),
                        new CompoundStatement(new AssignStatement("a", new ValueExpression(new BoolValue(true))),
                                new CompoundStatement(new IfStatement(new VariableExpression("a"),new AssignStatement("v",new ValueExpression(new
                                        IntValue(2))), new AssignStatement("v", new ValueExpression(new IntValue(3)))), new PrintStatement(new
                                        VariableExpression("v"))))));
    }
    public static String getTextExampleThree(){
        return new String("bool a; \t a = true; \t int v; \t If a Then v = 2 Else v = 3; \t print(v);");
    }
    public static String getTextExampleFour(){
        return new String("string varf; \t varf=\"test.in\"; \t openRFile(varf); \t int varc; \t readFile(varf,varc); \t print(varc); \t readFile(varf,varc); \t print(varc); \t closeRFile(varf)");
    }
    public static Statement getExampleFourCompound(){
        return new CompoundStatement(new VariableDeclarationStatement("varf",new STRINGtype()),
                new CompoundStatement(new AssignStatement("varf",new ValueExpression(new StringValue("test.in"))),
                        new CompoundStatement(new OpenFileStatement(new VariableExpression("varf")),
                                new CompoundStatement(new VariableDeclarationStatement("varc",new INTtype()),
                                        new CompoundStatement(new ReadFileStatement(new VariableExpression("varf"),"varc"),
                                                new CompoundStatement( new PrintStatement(new VariableExpression("varc")),
                                                        new CompoundStatement(new ReadFileStatement(new VariableExpression("varf"),"varc"),
                                                                new CompoundStatement(new PrintStatement(new VariableExpression("varc")), new CloseFileStatement(new VariableExpression("varf"))))))))));
    }
    public static MyStack<Statement> getExampleFour(){
        //string varf;
        //varf="test.in";
        //openRFile(varf);
        //int varc;
        //readFile(varf,varc);print(varc);
        //readFile(varf,varc);print(varc)
        //closeRFile(varf)
        System.out.println("LABORATORY 3\n");
        Statement firstStatement = new VariableDeclarationStatement("varf",new STRINGtype());
        Statement secondStatement = new AssignStatement("varf",new ValueExpression(new StringValue("test.in")));
        Statement thirdStatement = new OpenFileStatement(new VariableExpression("varf"));
        Statement fourthStatement = new VariableDeclarationStatement("varc",new INTtype());
        Statement fifthStatement1 = new ReadFileStatement(new VariableExpression("varf"),"varc");
        Statement fifthStatement2 = new PrintStatement(new VariableExpression("varc"));
        Statement fifthStatement = new CompoundStatement(fifthStatement1,fifthStatement2);
        Statement sixthStatement1 = new ReadFileStatement(new VariableExpression("varf"),"varc");
        Statement sixthStatement2 = new PrintStatement(new VariableExpression("varc"));
        Statement sixthStatement = new CompoundStatement(sixthStatement1,sixthStatement2);
        Statement seventhStatement = new CloseFileStatement(new VariableExpression("varf"));
        MyStackImplementation<Statement> statements = new MyStackImplementation<>();
        statements.push(seventhStatement);
        statements.push(sixthStatement);
        statements.push(fifthStatement);
        statements.push(fourthStatement);
        statements.push(thirdStatement);
        statements.push(secondStatement);
        statements.push(firstStatement);
        return statements;
    }
    public static String getTextExampleFive(){
        return new String("Ref int v; \t new(v,20); \t Ref Ref int a; \t new(a,v); \t print(v); \t print(a)");
    }
    public static Statement getExampleFiveCompound(){
        return new CompoundStatement(new VariableDeclarationStatement("v", new REFtype(new INTtype())),
                new CompoundStatement(new NewStatement("v",new ValueExpression(new IntValue(20))),
                        new CompoundStatement(new VariableDeclarationStatement("a", new REFtype(new REFtype(new INTtype()))),
                                new CompoundStatement(new NewStatement("a",new VariableExpression("v")),
                                        new CompoundStatement(new PrintStatement(new VariableExpression("v")),new PrintStatement(new VariableExpression("a")))))));
    }
    public static MyStack<Statement> getExampleFive(){
//        Ref int v;new(v,20);Ref Ref int a; new(a,v);print(v);print(a)
//        At the end of execution: Heap={1->20, 2->(1,int)}, SymTable={v->(1,int), a->(2,Ref int)} and Out={(1,int),(2,Ref int)}
        Statement firstStatement = new VariableDeclarationStatement("v",new REFtype(new INTtype()));
        Statement secondStatement = new NewStatement("v",new ValueExpression(new IntValue(20)));
        Statement thirdStatement = new VariableDeclarationStatement("a", new REFtype(new REFtype(new INTtype())));
        Statement fourthStatement = new NewStatement("a",new VariableExpression("v"));
        Statement fifthStatement = new PrintStatement(new VariableExpression("v"));
        Statement sixthStatement = new PrintStatement(new VariableExpression("a"));
        MyStackImplementation<Statement> statement = new MyStackImplementation<>();
        statement.push(sixthStatement);
        statement.push(fifthStatement);
        statement.push(fourthStatement);
        statement.push(thirdStatement);
        statement.push(secondStatement);
        statement.push(firstStatement);
        return statement;
    }

    public static MyStack<Statement> getExampleSix(){
//        Ref int v;new(v,20);Ref Ref int a; new(a,v);print(rH(v));print(rH(rH(a))+5)
//        At the end of execution: Heap={1->20, 2->(1,int)}, SymTable={v->(1,int), a->(2,Ref int)} and Out={20, 25}
        Statement firstStatement = new VariableDeclarationStatement("v", new REFtype(new INTtype()));
        Statement secondStatement = new NewStatement("v", new ValueExpression(new IntValue(20)));
        Statement thirdStatement = new VariableDeclarationStatement("a",new REFtype(new REFtype(new INTtype())));
        Statement fourthStatement = new NewStatement("a",new VariableExpression("v"));
        Statement fifthStatement = new PrintStatement(new ReadHeapExpression(new VariableExpression("v")));
        Statement sixthStatement = new PrintStatement(new ArithmeticExpression(new ReadHeapExpression(new ReadHeapExpression(new VariableExpression("a"))),new ValueExpression(new IntValue(5)),OperationsWithIntegers.SUM));
        MyStackImplementation<Statement> statements = new MyStackImplementation<>();
        statements.push(sixthStatement);
        statements.push(fifthStatement);
        statements.push(fourthStatement);
        statements.push(thirdStatement);
        statements.push(secondStatement);
        statements.push(firstStatement);
        return statements;
    }

    public static MyStack<Statement> getExampleSeven(){
//        Ref int v;new(v,20);print(rH(v)); wH(v,30);print(rH(v)+5);
//        At the end of execution: Heap={1->30}, SymTable={v->(1,int)} and Out={20, 35}
        Statement firstStatement = new VariableDeclarationStatement("v",new REFtype(new INTtype()));
        Statement secondStatement = new NewStatement("v",new ValueExpression(new IntValue(20)));
        Statement thirdStatement = new PrintStatement(new ReadHeapExpression(new VariableExpression("v")));
        Statement fourthStatement = new WriteHeapStatement("v",new ValueExpression(new IntValue(30)));
        Statement fifthStatement = new PrintStatement(new ArithmeticExpression(new ReadHeapExpression(new VariableExpression("v")),new ValueExpression(new IntValue(5)),OperationsWithIntegers.SUM));
        MyStackImplementation<Statement>statements  = new MyStackImplementation<>();
        statements.push(fifthStatement);
        statements.push(fourthStatement);
        statements.push(thirdStatement);
        statements.push(secondStatement);
        statements.push(firstStatement);
        return statements;
    }

    public static MyStack<Statement> getExampleEight(){
//        Ref int v;new(v,20);Ref Ref int a; new(a,v); new(v,30);print(rH(rH(a)))
        Statement statement = new VariableDeclarationStatement("v",new REFtype(new INTtype()));
        Statement statement1 = new NewStatement("v",new ValueExpression(new IntValue(20)));
        Statement statement2 = new VariableDeclarationStatement("a",new REFtype(new REFtype(new INTtype())));
        Statement statement3 = new NewStatement("a",new VariableExpression("v"));
        Statement statement5 = new NewStatement("v",new ValueExpression(new IntValue(30)));
        Statement statement4 = new PrintStatement(new ReadHeapExpression(new ReadHeapExpression(new VariableExpression("a"))));
        MyStackImplementation<Statement> statements = new MyStackImplementation<>();
        statements.push(statement4);
        statements.push(statement5);
        statements.push(statement3);
        statements.push(statement2);
        statements.push(statement1);
        statements.push(statement);
        return statements;
    }

    public static MyStack<Statement> getExampleNine(){
//        int v; v=4; (while (v>0) print(v);v=v-1);print(v)
        Statement firstStatement = new VariableDeclarationStatement("v",new INTtype());
        Statement secondStatement = new AssignStatement("v",new ValueExpression(new IntValue(4)));
        Statement thirdStatement = new WhileStatement(new RelationalExpressions(new VariableExpression("v"),new ValueExpression(new IntValue(0)),OperationsWithIntegerExpressions.GREATERETHAN),
                new CompoundStatement(new PrintStatement(new VariableExpression("v")),new AssignStatement("v",
                        new ArithmeticExpression(new VariableExpression("v"),new ValueExpression(new IntValue(1)),OperationsWithIntegers.DIFFERENCE))));
        MyStackImplementation<Statement> statements = new MyStackImplementation<>();
        Statement fourthStatement = new PrintStatement(new VariableExpression("v"));
        statements.push(fourthStatement);
        statements.push(thirdStatement);
        statements.push(secondStatement);
        statements.push(firstStatement);

        return statements;
    }
    public static String getTextExampleTen(){
        return new String("int v; Ref int a; v=10;new(a,22);fork(wH(a,30);v=32;print(v);print(rH(a))); print(v);print(rH(a))");
    }
    public static Statement getExampleTenCompound(){
        Statement fifthStatement = new WriteHeapStatement("a", new ValueExpression(new IntValue(30)));
        Statement sixthStatement = new AssignStatement("v",new ValueExpression(new IntValue(32)));
        Statement seventhStatement = new PrintStatement(new VariableExpression("v"));
        Statement eighthStatement = new PrintStatement(new ReadHeapExpression(new VariableExpression("a")));
        return new CompoundStatement(new VariableDeclarationStatement("v", new INTtype()),
                new CompoundStatement(new VariableDeclarationStatement("a", new REFtype(new INTtype())),
                        new CompoundStatement(new AssignStatement("v",new ValueExpression(new IntValue(10))),
                                new CompoundStatement(new NewStatement("a",new ValueExpression(new IntValue(22))),
                                        new CompoundStatement(new WriteHeapStatement("a", new ValueExpression(new IntValue(30))),
                                                new CompoundStatement(new AssignStatement("v",new ValueExpression(new IntValue(32))),
                                                        new CompoundStatement(new PrintStatement(new VariableExpression("v")),
                                                                new CompoundStatement(new PrintStatement(new ReadHeapExpression(new VariableExpression("a"))),new ForkStatement(new CompoundStatement(fifthStatement, new CompoundStatement(sixthStatement, new CompoundStatement(seventhStatement, eighthStatement))))))))))));
    }

    public static MyStack<Statement> getExampleTen(){
        // int v; Ref int a; v=10;new(a,22);fork(wH(a,30);v=32;print(v);print(rH(a))); print(v);print(rH(a))
        Statement firstStatement = new VariableDeclarationStatement("v", new INTtype());
        Statement secondStatement = new VariableDeclarationStatement("a", new REFtype(new INTtype()));
        Statement thirdStatement = new AssignStatement("v",new ValueExpression(new IntValue(10)));
        Statement fourthStatement =  new NewStatement("a",new ValueExpression(new IntValue(22)));
        Statement fifthStatement = new WriteHeapStatement("a", new ValueExpression(new IntValue(30)));
        Statement sixthStatement = new AssignStatement("v",new ValueExpression(new IntValue(32)));
        Statement seventhStatement = new PrintStatement(new VariableExpression("v"));
        Statement eighthStatement = new PrintStatement(new ReadHeapExpression(new VariableExpression("a")));
        Statement ninthStatement = new PrintStatement(new VariableExpression("v"));
        Statement tenthStatement = new PrintStatement(new ReadHeapExpression(new VariableExpression("a")));
        Statement fork = new ForkStatement(new CompoundStatement(fifthStatement, new CompoundStatement(sixthStatement, new CompoundStatement(seventhStatement, eighthStatement))));

        MyStackImplementation<Statement> statements = new MyStackImplementation<>();
        statements.push(tenthStatement);
        statements.push(ninthStatement);
        statements.push(fork);
        statements.push(fourthStatement);
        statements.push(thirdStatement);
        statements.push(secondStatement);
        statements.push(firstStatement);
        return statements;
    }
//
//    Ref int a; new(a,20);
//    (for(v=0;v<3;v=v+1) fork(print(v);v=v*rh(a)));
//    print(rh(a))

}

