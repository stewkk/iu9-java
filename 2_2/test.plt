#!/usr/bin/env -S gnuplot

set key off
file='plot.dat'
stats file nooutput
splot for [i=1:STATS_columns:3] 'plot.dat' using i:i+1:i+2 with linesp ls 2
# plot 'plot.dat' using 1:2 with dots dt 2 lw 4, 'plot.dat' using 4:5 with dots dt 2 lw 4
pause -1
