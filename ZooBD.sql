PGDMP                         x            ZOO    12.3    12.3 3    X           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            Y           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            Z           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            [           1262    49152    ZOO    DATABASE     �   CREATE DATABASE "ZOO" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE "ZOO";
                postgres    false            �            1259    49159 
   valaliment    SEQUENCE     u   CREATE SEQUENCE public.valaliment
    START WITH 10
    INCREMENT BY 10
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.valaliment;
       public          postgres    false            �            1259    57416    aliment    TABLE     �   CREATE TABLE public.aliment (
    idaliment integer DEFAULT nextval('public.valaliment'::regclass) NOT NULL,
    descripcion character varying(15)
);
    DROP TABLE public.aliment;
       public         heap    postgres    false    205            �            1259    57634    animal    TABLE     �   CREATE TABLE public.animal (
    nombrec character varying(30) NOT NULL,
    nombren character varying(30) NOT NULL,
    cantidad integer,
    nombre character varying,
    idaliment integer
);
    DROP TABLE public.animal;
       public         heap    postgres    false            �            1259    57564 	   categoria    TABLE     �   CREATE TABLE public.categoria (
    nombre character varying(20) NOT NULL,
    idreproduccion integer,
    idestructura integer
);
    DROP TABLE public.categoria;
       public         heap    postgres    false            �            1259    57510 
   valestruct    SEQUENCE     v   CREATE SEQUENCE public.valestruct
    START WITH 500
    INCREMENT BY 5
    NO MINVALUE
    MAXVALUE 600
    CACHE 1;
 !   DROP SEQUENCE public.valestruct;
       public          postgres    false            �            1259    57512 
   estructura    TABLE     �   CREATE TABLE public.estructura (
    idestructura integer DEFAULT nextval('public.valestruct'::regclass) NOT NULL,
    descripcion character varying(20)
);
    DROP TABLE public.estructura;
       public         heap    postgres    false    211            �            1259    49155 
   valhabitad    SEQUENCE     v   CREATE SEQUENCE public.valhabitad
    START WITH 100
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 200
    CACHE 1;
 !   DROP SEQUENCE public.valhabitad;
       public          postgres    false            �            1259    57410    habitad    TABLE     �   CREATE TABLE public.habitad (
    idhabitad integer DEFAULT nextval('public.valhabitad'::regclass) NOT NULL,
    descripcion character varying(30)
);
    DROP TABLE public.habitad;
       public         heap    postgres    false    203            �            1259    49157    valmove    SEQUENCE     s   CREATE SEQUENCE public.valmove
    START WITH 300
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 400
    CACHE 1;
    DROP SEQUENCE public.valmove;
       public          postgres    false            �            1259    57404    medio    TABLE     �   CREATE TABLE public.medio (
    idmedio integer DEFAULT nextval('public.valmove'::regclass) NOT NULL,
    descripcion character varying(30)
);
    DROP TABLE public.medio;
       public         heap    postgres    false    204            �            1259    57672    moviliza    TABLE     k   CREATE TABLE public.moviliza (
    nombrec character varying(30) NOT NULL,
    idmedio integer NOT NULL
);
    DROP TABLE public.moviliza;
       public         heap    postgres    false            �            1259    49161    valrepro    SEQUENCE     q   CREATE SEQUENCE public.valrepro
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10
    CACHE 1;
    DROP SEQUENCE public.valrepro;
       public          postgres    false            �            1259    57398    reproduccion    TABLE     �   CREATE TABLE public.reproduccion (
    idreproduccion integer DEFAULT nextval('public.valrepro'::regclass) NOT NULL,
    descripcion character varying(15)
);
     DROP TABLE public.reproduccion;
       public         heap    postgres    false    206            �            1259    49153    valcategory    SEQUENCE     v   CREATE SEQUENCE public.valcategory
    START WITH 200
    INCREMENT BY 2
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.valcategory;
       public          postgres    false            �            1259    57657    vive    TABLE     i   CREATE TABLE public.vive (
    nombrec character varying(30) NOT NULL,
    idhabitad integer NOT NULL
);
    DROP TABLE public.vive;
       public         heap    postgres    false            O          0    57416    aliment 
   TABLE DATA           9   COPY public.aliment (idaliment, descripcion) FROM stdin;
    public          postgres    false    210   m8       S          0    57634    animal 
   TABLE DATA           O   COPY public.animal (nombrec, nombren, cantidad, nombre, idaliment) FROM stdin;
    public          postgres    false    214   �8       R          0    57564 	   categoria 
   TABLE DATA           I   COPY public.categoria (nombre, idreproduccion, idestructura) FROM stdin;
    public          postgres    false    213   �9       Q          0    57512 
   estructura 
   TABLE DATA           ?   COPY public.estructura (idestructura, descripcion) FROM stdin;
    public          postgres    false    212   :       N          0    57410    habitad 
   TABLE DATA           9   COPY public.habitad (idhabitad, descripcion) FROM stdin;
    public          postgres    false    209   T:       M          0    57404    medio 
   TABLE DATA           5   COPY public.medio (idmedio, descripcion) FROM stdin;
    public          postgres    false    208   �:       U          0    57672    moviliza 
   TABLE DATA           4   COPY public.moviliza (nombrec, idmedio) FROM stdin;
    public          postgres    false    216   �:       L          0    57398    reproduccion 
   TABLE DATA           C   COPY public.reproduccion (idreproduccion, descripcion) FROM stdin;
    public          postgres    false    207   �;       T          0    57657    vive 
   TABLE DATA           2   COPY public.vive (nombrec, idhabitad) FROM stdin;
    public          postgres    false    215   �;       \           0    0 
   valaliment    SEQUENCE SET     9   SELECT pg_catalog.setval('public.valaliment', 30, true);
          public          postgres    false    205            ]           0    0    valcategory    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.valcategory', 218, true);
          public          postgres    false    202            ^           0    0 
   valestruct    SEQUENCE SET     :   SELECT pg_catalog.setval('public.valestruct', 505, true);
          public          postgres    false    211            _           0    0 
   valhabitad    SEQUENCE SET     :   SELECT pg_catalog.setval('public.valhabitad', 104, true);
          public          postgres    false    203            `           0    0    valmove    SEQUENCE SET     7   SELECT pg_catalog.setval('public.valmove', 306, true);
          public          postgres    false    204            a           0    0    valrepro    SEQUENCE SET     6   SELECT pg_catalog.setval('public.valrepro', 3, true);
          public          postgres    false    206            �
           2606    57421    aliment aliment_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.aliment
    ADD CONSTRAINT aliment_pkey PRIMARY KEY (idaliment);
 >   ALTER TABLE ONLY public.aliment DROP CONSTRAINT aliment_pkey;
       public            postgres    false    210            �
           2606    57641    animal animal_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY (nombrec);
 <   ALTER TABLE ONLY public.animal DROP CONSTRAINT animal_pkey;
       public            postgres    false    214            �
           2606    57568    categoria categoria_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (nombre);
 B   ALTER TABLE ONLY public.categoria DROP CONSTRAINT categoria_pkey;
       public            postgres    false    213            �
           2606    57517    estructura estructura_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.estructura
    ADD CONSTRAINT estructura_pkey PRIMARY KEY (idestructura);
 D   ALTER TABLE ONLY public.estructura DROP CONSTRAINT estructura_pkey;
       public            postgres    false    212            �
           2606    57415    habitad habitad_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.habitad
    ADD CONSTRAINT habitad_pkey PRIMARY KEY (idhabitad);
 >   ALTER TABLE ONLY public.habitad DROP CONSTRAINT habitad_pkey;
       public            postgres    false    209            �
           2606    57409    medio medio_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.medio
    ADD CONSTRAINT medio_pkey PRIMARY KEY (idmedio);
 :   ALTER TABLE ONLY public.medio DROP CONSTRAINT medio_pkey;
       public            postgres    false    208            �
           2606    57676    moviliza moviliza_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.moviliza
    ADD CONSTRAINT moviliza_pkey PRIMARY KEY (nombrec, idmedio);
 @   ALTER TABLE ONLY public.moviliza DROP CONSTRAINT moviliza_pkey;
       public            postgres    false    216    216            �
           2606    57403    reproduccion reproduccion_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.reproduccion
    ADD CONSTRAINT reproduccion_pkey PRIMARY KEY (idreproduccion);
 H   ALTER TABLE ONLY public.reproduccion DROP CONSTRAINT reproduccion_pkey;
       public            postgres    false    207            �
           2606    57661    vive vive_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.vive
    ADD CONSTRAINT vive_pkey PRIMARY KEY (nombrec, idhabitad);
 8   ALTER TABLE ONLY public.vive DROP CONSTRAINT vive_pkey;
       public            postgres    false    215    215            �
           2606    57642    animal animal_idaliment_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_idaliment_fkey FOREIGN KEY (idaliment) REFERENCES public.aliment(idaliment) ON UPDATE CASCADE;
 F   ALTER TABLE ONLY public.animal DROP CONSTRAINT animal_idaliment_fkey;
       public          postgres    false    2742    214    210            �
           2606    57647    animal animal_nombre_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_nombre_fkey FOREIGN KEY (nombre) REFERENCES public.categoria(nombre) ON UPDATE CASCADE ON DELETE CASCADE;
 C   ALTER TABLE ONLY public.animal DROP CONSTRAINT animal_nombre_fkey;
       public          postgres    false    214    2746    213            �
           2606    57574 %   categoria categoria_idestructura_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_idestructura_fkey FOREIGN KEY (idestructura) REFERENCES public.estructura(idestructura);
 O   ALTER TABLE ONLY public.categoria DROP CONSTRAINT categoria_idestructura_fkey;
       public          postgres    false    2744    213    212            �
           2606    57569 '   categoria categoria_idreproduccion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_idreproduccion_fkey FOREIGN KEY (idreproduccion) REFERENCES public.reproduccion(idreproduccion);
 Q   ALTER TABLE ONLY public.categoria DROP CONSTRAINT categoria_idreproduccion_fkey;
       public          postgres    false    213    207    2736            �
           2606    57682    moviliza moviliza_idmedio_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.moviliza
    ADD CONSTRAINT moviliza_idmedio_fkey FOREIGN KEY (idmedio) REFERENCES public.medio(idmedio) ON UPDATE CASCADE ON DELETE SET NULL;
 H   ALTER TABLE ONLY public.moviliza DROP CONSTRAINT moviliza_idmedio_fkey;
       public          postgres    false    2738    216    208            �
           2606    57677    moviliza moviliza_nombrec_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.moviliza
    ADD CONSTRAINT moviliza_nombrec_fkey FOREIGN KEY (nombrec) REFERENCES public.animal(nombrec) ON UPDATE CASCADE ON DELETE CASCADE;
 H   ALTER TABLE ONLY public.moviliza DROP CONSTRAINT moviliza_nombrec_fkey;
       public          postgres    false    2748    216    214            �
           2606    57667    vive vive_idhabitad_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.vive
    ADD CONSTRAINT vive_idhabitad_fkey FOREIGN KEY (idhabitad) REFERENCES public.habitad(idhabitad) ON UPDATE CASCADE ON DELETE SET NULL;
 B   ALTER TABLE ONLY public.vive DROP CONSTRAINT vive_idhabitad_fkey;
       public          postgres    false    209    215    2740            �
           2606    57662    vive vive_nombrec_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.vive
    ADD CONSTRAINT vive_nombrec_fkey FOREIGN KEY (nombrec) REFERENCES public.animal(nombrec) ON UPDATE CASCADE ON DELETE CASCADE;
 @   ALTER TABLE ONLY public.vive DROP CONSTRAINT vive_nombrec_fkey;
       public          postgres    false    215    214    2748            O   )   x�34�tN,��,�/��22��H-*�p�8�s�1z\\\ &��      S   �   x�U��j�0E��W�J&��Lô]$��]7J��<V�c��W����G�6�9Zr��9B���J���'
�,�#9�6��RL�#<aۉO��0-���';��8�Ww����j�e����'��ǙRN��ab���[��0���]�������!b���G���J�����O,���i���:i�8�$����U��xAr$v��yh�n��n��%����kH./*u2��m���1�|/tv�      R   `   x�=�K
� @�z���Dkն͔#�S~:��}4x�9�^�JÍsDI�X!�i4KqmxerX�R�q n���v��ǙO6�U�wR��W%�      Q   &   x�350�K-*IM*JL�/�250���+C����� ���      N   A   x�340�t�/.,M�240�N�)K��8���@LcN��������<΀D //�+F��� 3��      M   D   x�360�I-*J-.)J�260���I�K���9�J����ǔ3 �(�3��KL�c���� 
��      U   �   x�5�K�0D��>���J�X� l�bK&�j����P6#�����J��{��O���v��F^ֆX��]Y��DW6_d�QjPk�B��䄑T�k'5d�Jw��Ҥ�n�Q9Τl��R�0Fz+g��W�o�{ � Aa<�      L   #   x�3��,�,H,��2�􇲌���2�x� ;L      T   �   x�5�A�0��~jE?�"q���8�"�L�I��ZzYyǫ�:.K3d�����7V14х�١�ء��=(�$E�B\*�0w�n��� �*Τl��▜�7��'��V�X�Z��wo��p�>��	���1�� _�<�     