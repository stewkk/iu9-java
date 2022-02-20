
.PHONY: all

all: lectures.pdf

lectures.pdf: lectures.org
	pandoc -s --toc --template pandoc.template --pdf-engine=latexmk --pdf-engine-opt="-lualatex" lectures.org -o lectures.pdf


