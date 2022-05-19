# Lab05 - Mundo de Wumpus

Estrutura de pastas:

~~~
├── README.md  <- arquivo apresentando a tarefa
│
└── src <- pasta de arquivos fonte Java (.java)
|   │
|   └── pt <- raiz do seu pacote
|       │
|       └── c40task
|           │
|           └── l05wumpus <- arquivos fonte .java (feitos no eclipse ou equivalente)
│
└── bin <- pasta de arquivos binários Java (.class)
    │
    └── pt <- raiz do seu pacote
        │
        └── c40task
            │
            └── l05wumpus <- arquivos binários .class
~~~

## Arquivos Java sobre Mundo de Wumpus

> [Arquivos Java](https://github.com/caiomelloni/MC322/tree/main/lab05/src/pt/c40task/l05wumpus)

## Destaques do projeto
- Para o projeto foram usadas diversas características de POO, como encapsulamento, amarração, etc.
- Exemplo de uso do Polimorfismo no projeto:
    - nesse exemplo a variável comp é declarada como Componente, mas recebe valor de subclasses a depender da função
```java
    	Componente comp;
		
		switch(funcao) {
		case 'P':
			Heroi heroi = new Heroi(x, y, "RODOLFO");
			comp = heroi;
			controle.conectaHeroi(heroi);
			qtdHeroi++;
			break;
		case 'B':
			comp = new Buraco(x, y);
			qtdBuraco++;
			break;
		case 'W':
			comp = new Wumpus(x, y);
			qtdWumpus++;
			break;
		case 'O':
			qtdOuro++;
			comp = new Ouro(x, y);
			break;
		default:
			comp = new Vazio(x,y);
		}

```