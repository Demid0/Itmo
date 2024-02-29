mkdir /home/studs/s367522/lab0/
touch /home/studs/s367522/lab0/gigalith3 /home/studs/s367522/lab0/hitmonchan6 /home/studs/s367522/lab0/meganium7
echo -e "Способности Harden Sand-Attack Headbutt Rock Blast\nMud-Slap Iron Defense Smack Down Power Gem Rock Slide Stealth Rock\nSandstorm Stone Edge Explosion" > /home/studs/s367522/lab0/gigalith3
echo -e "satk=4 sdef=11\nspd=8" > /home/studs/s367522/lab0/hitmonchan6
echo -e "Тип покемона GRASS NONE" > /home/studs/s367522/lab0/meganium7
mkdir /home/studs/s367522/lab0/mienfoo5 /home/studs/s367522/lab0/paras2 /home/studs/s367522/lab0/salamence2
touch /home/studs/s367522/lab0/mienfoo5/vullaby /home/studs/s367522/lab0/mienfoo5/yanma /home/studs/s367522/lab0/mienfoo5/sealeo
echo -e "Развитые\nспособности Weak Armor" > /home/studs/s367522/lab0/mienfoo5/vullaby
echo -e "weigth=83.8 height=47.0 atk=7\ndef=5" > /home/studs/s367522/lab0/mienfoo5/yanma
echo -e "Тип покемона ICE WATER" > /home/studs/s367522/lab0/mienfoo5/sealeo
mkdir /home/studs/s367522/lab0/mienfoo5/quagsire /home/studs/s367522/lab0/mienfoo5/geodude
touch /home/studs/s367522/lab0/paras2/gigalith /home/studs/s367522/lab0/paras2/silcoon
echo -e "Тип диеты\nTerravore" > /home/studs/s367522/lab0/paras2/gigalith
echo -e "weigth=22.0 height=24.0 atk=4 def=6" > /home/studs/s367522/lab0/paras2/silcoon
mkdir /home/studs/s367522/lab0/paras2/victreebel /home/studs/s367522/lab0/paras2/ekans
mkdir /home/studs/s367522/lab0/salamence2/scolipede /home/studs/s367522/lab0/salamence2/wobbuffet /home/studs/s367522/lab0/salamence2/budew

chmod u=rw,g=r,o= /home/studs/s367522/lab0/gigalith3
chmod u=rw,g=w,o=r /home/studs/s367522/lab0/hitmonchan6
chmod u=r,g=r,o= /home/studs/s367522/lab0/meganium7
chmod u=wx,g=wx,o=rx /home/studs/s367522/lab0/mienfoo5
chmod 570 /home/studs/s367522/lab0/mienfoo5/quagsire
chmod 604 /home/studs/s367522/lab0/mienfoo5/vullaby
chmod u=r,g=,o= /home/studs/s367522/lab0/mienfoo5/yanma
chmod 004 /home/studs/s367522/lab0/mienfoo5/sealeo
chmod u=wx,g=wx,o=rx /home/studs/s367522/lab0/mienfoo5/geodude
chmod 573 /home/studs/s367522/lab0/paras2
chmod u=rwx,g=rx,o=w /home/studs/s367522/lab0/paras2/victreebel
chmod u=r,g=,o=r /home/studs/s367522/lab0/paras2/gigalith
chmod 335 /home/studs/s367522/lab0/paras2/ekans
chmod 400 /home/studs/s367522/lab0/paras2/silcoon
chmod u=rx,g=x,o=w /home/studs/s367522/lab0/salamence2
chmod 333 /home/studs/s367522/lab0/salamence2/scolipede
chmod u=rx,g=x,o=w /home/studs/s367522/lab0/salamence2/wobbuffet
chmod 512 /home/studs/s367522/lab0/salamence2/budew

cp -R ~/lab0/mienfoo5 ~/lab0/salamence2/wobbuffet/
chmod u+w ~/lab0/salamence2/wobbuffet/ 
chmod u+r ~/lab0/mienfoo5 ~/lab0/mienfoo5/geodude ~/lab0/mienfoo5/sealeo
cp -R ~/lab0/mienfoo5 ~/lab0/salamence2/wobbuffet/
chmod u-w ~/lab0/salamence2/wobbuffet/ 
chmod u-r ~/lab0/mienfoo5 ~/lab0/mienfoo5/geodude ~/lab0/mienfoo5/sealeo
ln ~/lab0/gigalith3 ~/lab0/mienfoo5/sealeogigalith
cp ~/lab0/hitmonchan6 ~/lab0/mienfoo5/quagsire
chmod u+w ~/lab0/mienfoo5/quagsire
cp ~/lab0/hitmonchan6 ~/lab0/mienfoo5/quagsire
chmod u-w ~/lab0/mienfoo5/quagsire
ln -s ~/lab0/mienfoo5 ~/lab0/Copy_6
cat ~/lab0/mienfoo5/sealeo ~/lab0/mienfoo5/vullaby > ~/lab0/meganium7_99
chmod u+r ~/lab0/mienfoo5/sealeo
cat ~/lab0/mienfoo5/sealeo ~/lab0/mienfoo5/vullaby > ~/lab0/meganium7_99
ln -s ~/lab0/gigalith3 ~/lab0/mienfoo5/vullabygigalith
cp ~/lab0/gigalith3 ~/lab0/paras2/silcoongigalith
chmod u+w ~/lab0/paras2/
cp ~/lab0/gigalith3 ~/lab0/paras2/silcoongigalith
chmod u-w ~/lab0/paras2/

wc -l ~/lab0/salamence2/* ~/lab0/salamence2/*/* ~/lab0/salamence2/*/*/* | grep -v "total" | sort -r
ls -Sr ~/lab0/** 2>&1 | grep "^s"
cat -n ~/lab0/paras2/** 2>&1 | grep -iv "r$"
cat ~/lab0/s* ~/lab0/**/s* 2>/dev/null | sort
wc -m ~/lab0/*e ~/lab0/**/*e 2>&1 | sort
cat ~/lab0/hitmonchan6 2>&1 | sort

rm ~/lab0/gigalith3
chmod u+r ~/lab0/mienfoo5/
chmod u+w ~/lab0/mienfoo5/yanma
rm ~/lab0/mienfoo5/yanma
rm ~/lab0/Copy*
rm ~/lab0/mienfoo5/sealeogigali*
chmod u-r ~/lab0/mienfoo5/
chmod u+w ~/lab0/paras2/
chmod -R 777 ~/lab0/paras2/ekans/
rm -r ~/lab0/paras2/ekans
chmod u-w ~/lab0/paras2/
