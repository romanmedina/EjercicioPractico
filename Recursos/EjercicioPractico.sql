PGDMP     9    2                z            ejercicio_practico_db    14.5    14.5                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24671    ejercicio_practico_db    DATABASE     p   CREATE DATABASE ejercicio_practico_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Peru.1252';
 %   DROP DATABASE ejercicio_practico_db;
                postgres    false                       0    0    DATABASE ejercicio_practico_db    COMMENT     K   COMMENT ON DATABASE ejercicio_practico_db IS 'Ejercicio practico NTTDATA';
                   postgres    false    3343            ?            1259    24861    cliente    TABLE     ?   CREATE TABLE public.cliente (
    contrasena character varying(30) NOT NULL,
    estado boolean NOT NULL,
    id integer NOT NULL
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            ?            1259    24867    cuenta    TABLE       CREATE TABLE public.cuenta (
    id_cuenta integer NOT NULL,
    estado boolean NOT NULL,
    numero_cuenta character varying(30) NOT NULL,
    saldo_inicial double precision NOT NULL,
    tipo_cuenta character varying(30) NOT NULL,
    id_cliente integer NOT NULL
);
    DROP TABLE public.cuenta;
       public         heap    postgres    false            ?            1259    24866    cuenta_id_cuenta_seq    SEQUENCE     ?   CREATE SEQUENCE public.cuenta_id_cuenta_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.cuenta_id_cuenta_seq;
       public          postgres    false    211                       0    0    cuenta_id_cuenta_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.cuenta_id_cuenta_seq OWNED BY public.cuenta.id_cuenta;
          public          postgres    false    210            ?            1259    24874    movimientos    TABLE       CREATE TABLE public.movimientos (
    id_movimiento integer NOT NULL,
    fecha timestamp without time zone NOT NULL,
    saldo double precision NOT NULL,
    tipo_movimiento character varying(30) NOT NULL,
    valor double precision NOT NULL,
    id_cuenta integer NOT NULL
);
    DROP TABLE public.movimientos;
       public         heap    postgres    false            ?            1259    24873    movimientos_id_movimiento_seq    SEQUENCE     ?   CREATE SEQUENCE public.movimientos_id_movimiento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.movimientos_id_movimiento_seq;
       public          postgres    false    213                       0    0    movimientos_id_movimiento_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.movimientos_id_movimiento_seq OWNED BY public.movimientos.id_movimiento;
          public          postgres    false    212            ?            1259    24881    persona    TABLE     +  CREATE TABLE public.persona (
    id integer NOT NULL,
    direccion character varying(30) NOT NULL,
    edad integer NOT NULL,
    genero character varying(30) NOT NULL,
    identificacion integer NOT NULL,
    nombre character varying(100) NOT NULL,
    telefono character varying(30) NOT NULL
);
    DROP TABLE public.persona;
       public         heap    postgres    false            ?            1259    24880    persona_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.persona_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.persona_id_seq;
       public          postgres    false    215                       0    0    persona_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.persona_id_seq OWNED BY public.persona.id;
          public          postgres    false    214            j           2604    24870    cuenta id_cuenta    DEFAULT     t   ALTER TABLE ONLY public.cuenta ALTER COLUMN id_cuenta SET DEFAULT nextval('public.cuenta_id_cuenta_seq'::regclass);
 ?   ALTER TABLE public.cuenta ALTER COLUMN id_cuenta DROP DEFAULT;
       public          postgres    false    211    210    211            k           2604    24877    movimientos id_movimiento    DEFAULT     ?   ALTER TABLE ONLY public.movimientos ALTER COLUMN id_movimiento SET DEFAULT nextval('public.movimientos_id_movimiento_seq'::regclass);
 H   ALTER TABLE public.movimientos ALTER COLUMN id_movimiento DROP DEFAULT;
       public          postgres    false    212    213    213            l           2604    24884 
   persona id    DEFAULT     h   ALTER TABLE ONLY public.persona ALTER COLUMN id SET DEFAULT nextval('public.persona_id_seq'::regclass);
 9   ALTER TABLE public.persona ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215                      0    24861    cliente 
   TABLE DATA           9   COPY public.cliente (contrasena, estado, id) FROM stdin;
    public          postgres    false    209   ?$                 0    24867    cuenta 
   TABLE DATA           j   COPY public.cuenta (id_cuenta, estado, numero_cuenta, saldo_inicial, tipo_cuenta, id_cliente) FROM stdin;
    public          postgres    false    211   ?$                 0    24874    movimientos 
   TABLE DATA           e   COPY public.movimientos (id_movimiento, fecha, saldo, tipo_movimiento, valor, id_cuenta) FROM stdin;
    public          postgres    false    213   Z%       	          0    24881    persona 
   TABLE DATA           `   COPY public.persona (id, direccion, edad, genero, identificacion, nombre, telefono) FROM stdin;
    public          postgres    false    215   ?%                  0    0    cuenta_id_cuenta_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.cuenta_id_cuenta_seq', 4, true);
          public          postgres    false    210                       0    0    movimientos_id_movimiento_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.movimientos_id_movimiento_seq', 2, true);
          public          postgres    false    212                       0    0    persona_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.persona_id_seq', 3, true);
          public          postgres    false    214            n           2606    24865    cliente cliente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    209            p           2606    24872    cuenta cuenta_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pkey PRIMARY KEY (id_cuenta);
 <   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT cuenta_pkey;
       public            postgres    false    211            r           2606    24879    movimientos movimientos_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT movimientos_pkey PRIMARY KEY (id_movimiento);
 F   ALTER TABLE ONLY public.movimientos DROP CONSTRAINT movimientos_pkey;
       public            postgres    false    213            t           2606    24886    persona persona_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public            postgres    false    215            v           2606    24892    cuenta fk_cliente_cuenta    FK CONSTRAINT     |   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT fk_cliente_cuenta FOREIGN KEY (id_cliente) REFERENCES public.cliente(id);
 B   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT fk_cliente_cuenta;
       public          postgres    false    211    3182    209            u           2606    24887    cliente fk_cliente_persona    FK CONSTRAINT     v   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_cliente_persona FOREIGN KEY (id) REFERENCES public.persona(id);
 D   ALTER TABLE ONLY public.cliente DROP CONSTRAINT fk_cliente_persona;
       public          postgres    false    209    3188    215            w           2606    24897     movimientos fk_movimiento_cuenta    FK CONSTRAINT     ?   ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT fk_movimiento_cuenta FOREIGN KEY (id_cuenta) REFERENCES public.cuenta(id_cuenta);
 J   ALTER TABLE ONLY public.movimientos DROP CONSTRAINT fk_movimiento_cuenta;
       public          postgres    false    213    211    3184               %   x?3426?,?4?253? 2???LL?c?=... ^y_         S   x?E?1
?0???0????Q??kA???*??{??p$f???#?-Ch쥳??ާ\I_?B??'<???m?	?         X   x?3?4202?5??52R04?26?22?
Y?p?p???g??+??*?? l?e??????@??????(T?Z?Y??+F??? h??      	   ?   x?m??? E??W???R`t???v???B0?QK1ѯ7?{?srZ?v|bL<?u????_<Bн??5.){~?B?Bu?(&???;???q?g??v?- ??|H?c|?*Ѫ3?WLB+??PHUrz?@ɹP3??`v%?秣 ?)?-|%??N?n??0;?     