#!/usr/bin/env bash

cat <<"EOF" | make
if (x12) {
    aoaoa = 01010;
    dadaya = 123345;
}
EOF

cat <<"EOF" | make
x = 1;
EOF

cat <<"EOF" | make
if (a)
   if (b)
       if (c)
           x = 123;
EOF

cat <<"EOF" | make
if (x123) {
   x123 = ;
}
EOF
