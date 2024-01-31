## 词法分析

我们令 **id** 表示以字母开头的包含字母、数字的字符串，id 定义了一个集合，称之为**语言（Language）**。

id 中使用了字母、数字等符号集合，称之为**字母表（Alphabet）**。

语言中的每个元素（标识符）称为**串（String）**。

> **字母表** $\Sigma$ 是一个有限的符号集合。
>
> 字母表 $\Sigma$ 上的**串**（$s$）是由 $\Sigma$ 中的符号组成的一个**有穷**序列。$\epsilon$ 表示空串，其长度 $|\epsilon| = 0$。

在两个串 $x$ 和 $y$ 上可以做连接运算 $xy$，例如：$x=\text{dog}, y = \text{house} \rightarrow xy=\text{doghouse}$。特殊的，$s\epsilon = \epsilon s = s$。 

由连接运算可以定义指数运算 $s^i$：
$$
\begin{aligned}
s^0 &\triangleq \epsilon \\
s^i &\triangleq ss^{i-1}, i>0
\end{aligned}
$$
意为自连接 $i$ 次。

**语言**是给定字母表 $\Sigma$ 上一个任意的**可数的**串集合。当集合中没有串时，称为**空语言** $\varnothing$。

> 注意区分 $\varnothing$ 和 $\{\epsilon\}$。
>
> 语言举例：**id**: $\{a, b, c, a1, a2, \dots\}$；**ws**: $\{\text{blank}, \text{tab}, \text{newline}\}$；**if**: $\{\text{if}\}$。

由于**语言是串的集合**，因此我们可以通过对集合的操作**构造**新的语言。

> 例如：
>
> - $L$ 和 $M$ 的并：$L \cup M = \left\{s \mid s \in L \or s \in M\right\}$；
> - $L$ 和 $M$ 的连接：$LM = \left\{xy \mid x \in L \and y \in M\right\}$；
> - $L$ 的幂：$L^i = \left\{s_1s_2\dots s_i \mid s_i \in L\right\}$，即 $L$ 中的任意元素连接 $i$ 次；
> - $L$ 的 Kleene 闭包：$L^* = \bigcup_{i=0}^\infty L^i$；
> - $L$ 的正闭包：$L^+ = \bigcup_{i=1}^\infty L^i$。

可以注意到
$$
\begin{aligned}
L^* &= L^0 \bigcup L^+ \\
L^+ &= LL^* = L^*L
\end{aligned}
$$
闭包运算允许我们通过有限的集合构造无穷集合。

> 令 $L$ 为所有大小写字母的集合，$D$ 为所有数字的集合，则 $L(L\cup D)^*$ 的含义为以字母开头的任意字母和数字组合的字符串。

对照语言举例，发现 **id** 的定义即为 $L(L\cup D)^*$。

如何让 parser 知道 **id** 是这样定义的？

### 正则表达式

每个正则表达式 $r$ 对应着一个正则语言 $L(r)$，正则表达式是**语法**，正则语言是**语义**。

正则表达式对应的正则语言：

$$
L(\epsilon) = \{\epsilon\}
$$

$$
L(a) = \{a\}, \forall a \in \Sigma
$$

$$
L((r)) = L(r)
$$

$$
L(r\mid s) = L(r) \bigcup L(s) \quad L(rs) = L(r)L(s) \quad L(r^*) = (L(r))^*
$$

正则表达式中的表达式及其匹配：

|     表达式     |                  匹配                   |     例子      |
| :------------: | :-------------------------------------: | :-----------: |
|      $c$       |        单个**非运算符**字符 $c$         |      $a$      |
| $\backslash c$ |          字符 $c$ 的**字面值**          | $\backslash*$ |
|     "$s$"      |           串 $s$ 的**字面值**           |    "$**$"     |
|       .        |       **除换行符以外**的任何字符        |    $a.*b$     |
|       ^        |               一行的开始                |     ^abc      |
|       $        |               一行的结尾                |     abc$      |
|     $[s]$      |       字符串 $s$ 中的任意一个字符       |    $[abc]$    |
|      [^s]      |     不在字符串 $s$ 中的任意一个字符     |    [^abc]     |
|      $r*$      |   和 $r$ 匹配的零个或多个串连接成的串   |     $a*$      |
|      $r+$      |   和 $r$ 匹配的一个或多个串连接成的串   |     $a+$      |
|      $r?$      |             零个或一个 $r$              |     $a?$      |
|   $r\{m,n\}$   | 最少 $m$ 个，最多 $n$ 个 $r$ 的重复出现 |  $a\{1,5\}$   |
|    $r_1r_2$    |           $r_1$ 后加上 $r_2$            |     $ab$      |
| $r_1 \mid r_2$ |             $r_1$ 或 $r_2$              |  $a \mid b$   |
|     $(r)$      |               与 $r$ 相同               |  $(a\mid b)$  |
|   $r_1/r_2$    |        后面跟有 $r_2$ 时的 $r_1$        |   $abc/123$   |
|    $r\{n\}$    |             恰好 $n$ 个 $r$             |   $a\{5\}$    |

有些固定的匹配可以简记：

- \w $\to$ [A-Za-z0-9_]；
- \W $\to$ [\^A-Za-z0-9_]；
- \d $\to$ [0-9]；
- \l $\to$ [a-z]；
- \\_s $\to$ [ \t\r\n\v\f]；
- \S $\to$ [\^ \t\r\n\v\f]；
- \u $\to$ [A-Z]。

> Q：$\left(0 \mid (1(01^*0)^*1)\right)^*$ 表达的是什么含义？
>
> A：通过 [regex101: build, test, and debug regex](https://regex101.com/) 找规律，给定若干01串，其匹配的是**十进制下 $3$ 的倍数的二进制**，即答案集合为
> $$
> \left\{(x)_2 \mid (x)_{10} \equiv 0 \pmod p\right\}
> $$

## 自动机

