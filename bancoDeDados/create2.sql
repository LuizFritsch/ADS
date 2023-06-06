PGDMP     "    (                {            postgres    15.1    15.1     N           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            O           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            P           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            Q           1262    5    postgres    DATABASE     t   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.UTF-8';
    DROP DATABASE postgres;
                postgres    false            R           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3665            �            1259    16458    aluguel    TABLE     �   CREATE TABLE public.aluguel (
    id uuid NOT NULL,
    fk_cliente_cpf text NOT NULL,
    fk_veiculo_placa text NOT NULL,
    data_inicio date NOT NULL,
    data_termino date NOT NULL,
    valor_total double precision DEFAULT 0 NOT NULL
);
    DROP TABLE public.aluguel;
       public         heap    postgres    false            �            1259    16388    cliente    TABLE     �   CREATE TABLE public.cliente (
    cpf text NOT NULL,
    nome text,
    categoria_cnh "char",
    data_nascimento date,
    endereco_completo text
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    16417 
   fabricante    TABLE     Q   CREATE TABLE public.fabricante (
    id uuid NOT NULL,
    nome text NOT NULL
);
    DROP TABLE public.fabricante;
       public         heap    postgres    false            �            1259    16489    historico_manutencao    TABLE     o   CREATE TABLE public.historico_manutencao (
    fk_servico uuid NOT NULL,
    fk_manutencao_id uuid NOT NULL
);
 (   DROP TABLE public.historico_manutencao;
       public         heap    postgres    false            �            1259    16476 
   manutencao    TABLE     �   CREATE TABLE public.manutencao (
    id uuid NOT NULL,
    fk_veiculo_placa text NOT NULL,
    valor_total double precision DEFAULT 1 NOT NULL,
    data_inicio date NOT NULL,
    data_fim date NOT NULL
);
    DROP TABLE public.manutencao;
       public         heap    postgres    false            �            1259    16407    modelo    TABLE     �   CREATE TABLE public.modelo (
    id uuid NOT NULL,
    nome text,
    ano integer DEFAULT 1990 NOT NULL,
    nmr_passageiros integer DEFAULT 1 NOT NULL,
    capacidade_portamala integer DEFAULT 1 NOT NULL,
    fk_fabricante_id uuid NOT NULL
);
    DROP TABLE public.modelo;
       public         heap    postgres    false            �            1259    16494    servico    TABLE     }   CREATE TABLE public.servico (
    id uuid NOT NULL,
    nome text NOT NULL,
    valor double precision DEFAULT 1 NOT NULL
);
    DROP TABLE public.servico;
       public         heap    postgres    false            �            1259    16395    veiculo    TABLE     �   CREATE TABLE public.veiculo (
    placa text NOT NULL,
    valor_dia double precision DEFAULT 0,
    valor_semana double precision DEFAULT 0,
    valor_mes double precision DEFAULT 0,
    fk_modelo_id uuid NOT NULL
);
    DROP TABLE public.veiculo;
       public         heap    postgres    false            �           2606    16465    aluguel aluguel_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.aluguel
    ADD CONSTRAINT aluguel_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.aluguel DROP CONSTRAINT aluguel_pkey;
       public            postgres    false    218            �           2606    16394    cliente cliente_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cpf);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    214            �           2606    16435    fabricante fabricante_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.fabricante
    ADD CONSTRAINT fabricante_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.fabricante DROP CONSTRAINT fabricante_pkey;
       public            postgres    false    217            �           2606    16483    manutencao manutencao_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.manutencao
    ADD CONSTRAINT manutencao_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.manutencao DROP CONSTRAINT manutencao_pkey;
       public            postgres    false    219            �           2606    16433    modelo modelo_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.modelo
    ADD CONSTRAINT modelo_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.modelo DROP CONSTRAINT modelo_pkey;
       public            postgres    false    216            �           2606    16501    servico servico_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.servico
    ADD CONSTRAINT servico_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.servico DROP CONSTRAINT servico_pkey;
       public            postgres    false    221            �           2606    16406    veiculo veiculo_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.veiculo
    ADD CONSTRAINT veiculo_pkey PRIMARY KEY (placa);
 >   ALTER TABLE ONLY public.veiculo DROP CONSTRAINT veiculo_pkey;
       public            postgres    false    215            �           2606    16466    aluguel fk_cpf    FK CONSTRAINT     w   ALTER TABLE ONLY public.aluguel
    ADD CONSTRAINT fk_cpf FOREIGN KEY (fk_cliente_cpf) REFERENCES public.cliente(cpf);
 8   ALTER TABLE ONLY public.aluguel DROP CONSTRAINT fk_cpf;
       public          postgres    false    218    214    3498            �           2606    16507 "   historico_manutencao fk_manutencao    FK CONSTRAINT     �   ALTER TABLE ONLY public.historico_manutencao
    ADD CONSTRAINT fk_manutencao FOREIGN KEY (fk_manutencao_id) REFERENCES public.manutencao(id) NOT VALID;
 L   ALTER TABLE ONLY public.historico_manutencao DROP CONSTRAINT fk_manutencao;
       public          postgres    false    3508    219    220            �           2606    16471    aluguel fk_placa    FK CONSTRAINT     }   ALTER TABLE ONLY public.aluguel
    ADD CONSTRAINT fk_placa FOREIGN KEY (fk_veiculo_placa) REFERENCES public.veiculo(placa);
 :   ALTER TABLE ONLY public.aluguel DROP CONSTRAINT fk_placa;
       public          postgres    false    218    215    3500            �           2606    16484    manutencao fk_placa    FK CONSTRAINT     �   ALTER TABLE ONLY public.manutencao
    ADD CONSTRAINT fk_placa FOREIGN KEY (fk_veiculo_placa) REFERENCES public.veiculo(placa) NOT VALID;
 =   ALTER TABLE ONLY public.manutencao DROP CONSTRAINT fk_placa;
       public          postgres    false    219    215    3500            �           2606    16502    historico_manutencao fk_servico    FK CONSTRAINT     �   ALTER TABLE ONLY public.historico_manutencao
    ADD CONSTRAINT fk_servico FOREIGN KEY (fk_servico) REFERENCES public.servico(id) NOT VALID;
 I   ALTER TABLE ONLY public.historico_manutencao DROP CONSTRAINT fk_servico;
       public          postgres    false    220    3510    221            �           2606    16436 #   modelo modelo_fk_fabricante_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.modelo
    ADD CONSTRAINT modelo_fk_fabricante_id_fkey FOREIGN KEY (fk_fabricante_id) REFERENCES public.fabricante(id) NOT VALID;
 M   ALTER TABLE ONLY public.modelo DROP CONSTRAINT modelo_fk_fabricante_id_fkey;
       public          postgres    false    3504    217    216            �           2606    16441 !   veiculo veiculo_fk_modelo_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.veiculo
    ADD CONSTRAINT veiculo_fk_modelo_id_fkey FOREIGN KEY (fk_modelo_id) REFERENCES public.modelo(id) NOT VALID;
 K   ALTER TABLE ONLY public.veiculo DROP CONSTRAINT veiculo_fk_modelo_id_fkey;
       public          postgres    false    3502    216    215           