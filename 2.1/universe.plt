#!/usr/bin/env -S gnuplot

#set terminal postscript
#set output '| ps2pdf - output.pdf'
#set terminal epslatex
#set output "plot.tex"
set key off
file='plot.dat'
stats file nooutput
splot 'plot.dat' using 1:2:3 with dots dt 2, for [i=4:STATS_columns:3] 'plot.dat' using i:i+1:i+2 with lines ls 1
pause -1
